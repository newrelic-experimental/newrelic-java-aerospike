package com.aerospike.client;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.aerospike.client.async.EventLoop;
import com.aerospike.client.cluster.Node;
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
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.IndexCollectionType;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.ExecuteTask;
import com.aerospike.client.task.IndexTask;
import com.newrelic.api.agent.DatastoreParameters;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.aerospike.Utils;

@Weave(type=MatchType.BaseClass)
public abstract class AerospikeClient {

	public void add(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "add";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		
		try {
			if(listener != null) {
				if(listener.segment == null) {
					listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
				}
				listener.params = Utils.getParams(key, opName);
			}
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void add(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "add";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void append(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "append";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void append(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "append";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public IndexTask createIndex(Policy policy, String namespace, String setName, String indexName, 
			String binName, IndexType indexType, IndexCollectionType indexCollectionType)   throws AerospikeException {
		String opName = "createIndex";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName", setName);
		attributes.put("IndexName", indexName);
		attributes.put("BinName", binName);
		attributes.put("IndexType", indexType);
		attributes.put("IndexCollectionType", indexCollectionType);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(setName, namespace, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void delete(EventLoop eventLoop, DeleteListener listener, WritePolicy policy, Key key)  throws AerospikeException {
		String opName = "delete";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean delete(WritePolicy policy, Key key)  throws AerospikeException {
		String opName = "delete";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void execute(EventLoop eventLoop,ExecuteListener listener,WritePolicy policy,Key key,
			String packageName,String functionName,Value... functionArgs)  throws AerospikeException {
		String opName = "execute";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		attributes.put("PackageName", packageName);
		attributes.put("FunctionName", functionName);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		String collName = null;
		if(key.setName != null) {
			collName = key.setName + "-" + packageName+"-"+functionName;
		} else {
			collName = "Unknown" + "-" + packageName+"-"+functionName;
		}
		DatastoreParameters params = DatastoreParameters.product("AeroSpike").collection(collName).operation(opName).noInstance().databaseName(key.namespace).build();
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = params;
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}

	}
	
	@Trace
	public Object execute(WritePolicy policy, Key key, String packageName, String functionName, Value... functionArgs) throws AerospikeException {
		String opName = "execute";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		attributes.put("PackageName", packageName);
		attributes.put("FunctionName", functionName);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		String collName = null;
		if(key.setName != null) {
			collName = key.setName + "-" + packageName+"-"+functionName;
		} else {
			collName = "Unknown" + "-" + packageName+"-"+functionName;
		}
		DatastoreParameters params = DatastoreParameters.product("AeroSpike").collection(collName).operation(opName).noInstance().databaseName(key.namespace).build();
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public ExecuteTask execute(WritePolicy policy,Statement statement,String packageName,String functionName,Value... functionArgs) throws AerospikeException {
		String opName = "execute";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("PackageName", packageName);
		attributes.put("FunctionName", functionName);
		Utils.reportStatement(attributes, statement);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		String collName = null;
		if(statement.getSetName() != null) {
			collName = statement.getSetName() + "-" + packageName+"-"+functionName;
		} else {
			collName = "Unknown" + "-" + packageName+"-"+functionName;
		}
		DatastoreParameters params = DatastoreParameters.product("AeroSpike").collection(collName).operation(opName).noInstance().databaseName(statement.getNamespace()).build();
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void exists(EventLoop eventLoop, ExistsArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "exists";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void exists(EventLoop eventLoop, ExistsListener listener, Policy policy, Key key) throws AerospikeException {
		String opName = "exists";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void exists(EventLoop eventLoop, ExistsSequenceListener listener, BatchPolicy policy, Key[] keys) {
		String opName = "exists";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean[] exists(BatchPolicy policy, Key[] keys) {
		String opName = "exists";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(keys, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean exists(Policy policy, Key key) {
		String opName = "exists";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void get(EventLoop eventLoop, BatchListListener listener, BatchPolicy policy, List<BatchRead> records) {
		String opName = "get";
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(records, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void get(EventLoop eventLoop, BatchSequenceListener listener, BatchPolicy policy, List<BatchRead> records) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int size = records.size();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++) {
			BatchRead bRead = records.get(i);
			Key bKey = bRead.key;
			sb.append(bKey);
			if(i < size -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(records, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void get(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
		
	public void get(EventLoop eventLoop, RecordListener listener, Policy policy, Key key) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
		
	public void get(EventLoop eventLoop, RecordListener listener, Policy policy, Key key, String... binNames) throws AerospikeException {	
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void get(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void get(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public Record[] get(BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(keys, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record[] get(BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(keys, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void put(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "put";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void put(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "put";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void prepend(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "prepend";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void prepend(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		String opName = "prepend";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void truncate(InfoPolicy policy, String ns, String set, Calendar beforeLastUpdate) throws AerospikeException {
		String opName = "truncate";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", ns);
		attributes.put("Set", set);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(set, ns, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void touch(WritePolicy policy, Key key) throws AerospikeException {
		String opName = "touch";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void touch(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key) throws AerospikeException {
		String opName = "touch";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record get(Policy policy, Key key) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record get(Policy policy, Key key, String... binNames) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		DatastoreParameters params = DatastoreParameters.product("AeroSpike").collection(key.setName != null ? key.setName : "Unknown").operation(opName).noInstance().databaseName(key.namespace).build();
		NewRelic.getAgent().getTracedMethod().reportAsExternal(params);
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record getHeader(Policy policy, Key key) throws AerospikeException {
		String opName = "getHeader";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void getHeader(EventLoop eventLoop, RecordListener listener, Policy policy, Key key) throws AerospikeException {
		String opName = "getHeader";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public boolean get(BatchPolicy policy, List<BatchRead> records) throws AerospikeException {
		String opName = "get";
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(records, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void get(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "get";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record[] getHeader(BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "getHeader";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(keys, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void getHeader(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "getHeader";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void getHeader(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		String opName = "getHeader";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		int length = keys.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++) {
			sb.append(keys[i]);
			if(i < length -1) {
				sb.append(',');
			}
		}
		if(!sb.toString().isEmpty()) {
			attributes.put("Keys", sb.toString());
		}
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(keys, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record operate(WritePolicy policy, Key key, Operation... operations) throws AerospikeException {
		String opName = "queryAggregateNode";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(key, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void operate(EventLoop eventLoop, RecordListener listener, WritePolicy policy, Key key, Operation... operations) throws AerospikeException {
		String opName = "operate";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Key", key.toString());
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(key, opName);
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void scanAll(ScanPolicy policy, String namespace, String setName, ScanCallback callback, String... binNames)
		throws AerospikeException {
		String opName = "scanAll";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName",setName);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(setName, namespace, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	public void scanAll(EventLoop eventLoop, RecordSequenceListener listener, ScanPolicy policy, String namespace, String setName, String... binNames) throws AerospikeException {
		String opName = "scanAll";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName",setName);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(namespace,setName, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void scanNode(ScanPolicy policy, String nodeName, String namespace, String setName, ScanCallback callback, String... binNames) 
		throws AerospikeException {
		String opName = "scanNode";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName",setName);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(setName, namespace, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void scanNode(ScanPolicy policy, Node node, String namespace, String setName, ScanCallback callback, String... binNames) 
		throws AerospikeException {
		String opName = "scanNode";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName",setName);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(setName, namespace, opName));
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public RecordSet query(QueryPolicy policy, Statement statement) throws AerospikeException {
		String opName = "query";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(statement, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	public void query(EventLoop eventLoop, RecordSequenceListener listener, QueryPolicy policy, Statement statement) throws AerospikeException {
		String opName = "query";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		if(listener != null) {
			if(listener.segment == null) {
				listener.segment = NewRelic.getAgent().getTransaction().startSegment("AeroSpikeClient-"+opName);
			}
			listener.params = Utils.getParams(statement, opName);
			listener.token = NewRelic.getAgent().getTransaction().getToken();
		}
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public RecordSet queryNode(QueryPolicy policy, Statement statement, Node node) throws AerospikeException {
		String opName = "queryNode";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(statement, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public ResultSet queryAggregate(QueryPolicy policy,Statement statement,String packageName,String functionName,
		Value... functionArgs) throws AerospikeException {
		String opName = "queryAggregate";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		attributes.put("PackageName", packageName);
		attributes.put("FunctionName", functionName);
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(statement, packageName, functionName, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public ResultSet queryAggregate(QueryPolicy policy, Statement statement) throws AerospikeException {
		String opName = "queryAggregate";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(statement, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public ResultSet queryAggregateNode(QueryPolicy policy, Statement statement, Node node) throws AerospikeException {
		String opName = "queryAggregateNode";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		Utils.reportStatement(attributes, statement);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(statement, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public IndexTask createIndex(Policy policy, String namespace, String setName, String indexName, String binName,
		IndexType indexType) throws AerospikeException {
		String opName = "createIndex";
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("Operation", opName);
		attributes.put("Namespace", namespace);
		attributes.put("SetName", setName);
		attributes.put("IndexName", indexName);
		attributes.put("IndexType", indexType);
		
		NewRelic.getAgent().getTracedMethod().addCustomAttributes(attributes);
		NewRelic.getAgent().getTracedMethod().reportAsExternal(Utils.getParams(setName, namespace, opName));
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

}
