package com.aerospike.client.listener;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.newrelic.api.agent.ExternalParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class RecordSequenceListener {
	
	@NewField
	public Segment segment = null;

	@NewField
	public ExternalParameters params = null;

	@NewField
	public Token token = null;

	@Trace(async=true)
	public void onRecord(Key key, Record record) {
		if(token != null) {
			token.link();
		}
		Weaver.callOriginal();
	}
	
	@Trace
	public void onSuccess() {
		if(token != null) {
			token.expire();
			token = null;
		}
		if(segment != null) {
			if(params != null) {
				segment.reportAsExternal(params);
			}
			segment.end();
			segment = null;
		}
		Weaver.callOriginal();
	}

	@Trace
	public void onFailure(AerospikeException exception) {
		NewRelic.noticeError(exception);
		if(token != null) {
			token.expire();
			token = null;
		}
		if(segment != null) {
			if(params != null) {
				segment.reportAsExternal(params);
			}
			segment.end();
			segment = null;
		}
		Weaver.callOriginal();
	}
}
