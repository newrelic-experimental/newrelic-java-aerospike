package com.aerospike.client.async;

import java.util.List;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.BatchRead;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Operation;
import com.aerospike.client.Value;
import com.aerospike.client.listener.BatchListListener;
import com.aerospike.client.listener.BatchSequenceListener;
import com.aerospike.client.listener.DeleteListener;
import com.aerospike.client.listener.ExecuteListener;
import com.aerospike.client.listener.ExistsArrayListener;
import com.aerospike.client.listener.ExistsListener;
import com.aerospike.client.listener.ExistsSequenceListener;
import com.aerospike.client.listener.RecordArrayListener;
import com.aerospike.client.listener.RecordListener;
import com.aerospike.client.listener.RecordSequenceListener;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Statement;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class IAsyncClient {

	@Trace
	public void put(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void append(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void prepend(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void add(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void delete(WritePolicy policy, DeleteListener listener, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void touch(WritePolicy policy, WriteListener listener, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void exists(Policy policy, ExistsListener listener, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void exists(BatchPolicy policy, ExistsArrayListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void exists(BatchPolicy policy, ExistsSequenceListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void get(Policy policy, RecordListener listener, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(Policy policy, RecordListener listener, Key key, String... binNames) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(Policy policy, RecordListener listener, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, BatchListListener listener, List<BatchRead> records) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, BatchSequenceListener listener, List<BatchRead> records) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, RecordArrayListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, RecordSequenceListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, RecordArrayListener listener, Key[] keys, String... binNames)  throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, RecordSequenceListener listener, Key[] keys, String... binNames)  throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(BatchPolicy policy, RecordArrayListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(BatchPolicy policy, RecordSequenceListener listener, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void operate(WritePolicy policy, RecordListener listener, Key key, Operation... operations) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void scanAll(ScanPolicy policy, RecordSequenceListener listener, String namespace, String setName, String... binNames) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void execute(WritePolicy policy,ExecuteListener listener,Key key,String packageName,String functionName,
			Value... functionArgs) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void query(QueryPolicy policy, RecordSequenceListener listener, Statement statement) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
}
