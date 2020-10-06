package com.aerospike.client;

import java.util.Calendar;
import java.util.List;

import com.aerospike.client.async.EventLoop;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.large.LargeList;
import com.aerospike.client.large.LargeMap;
import com.aerospike.client.large.LargeSet;
import com.aerospike.client.large.LargeStack;
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
import com.aerospike.client.task.RegisterTask;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class AerospikeClient {

	@Trace
	public void add(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void add(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void append(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void append(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
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
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void delete(EventLoop eventLoop, DeleteListener listener, WritePolicy policy, Key key)  throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean delete(WritePolicy policy, Key key)  throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void execute(EventLoop eventLoop,ExecuteListener listener,WritePolicy policy,Key key,
			String packageName,String functionName,Value... functionArgs)  throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}

	}
	
	@Trace
	public Object execute(WritePolicy policy, Key key, String packageName, String functionName, Value... functionArgs) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public ExecuteTask execute(WritePolicy policy,Statement statement,String packageName,String functionName,Value... functionArgs) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void exists(EventLoop eventLoop, ExistsArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void exists(EventLoop eventLoop, ExistsListener listener, Policy policy, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void exists(EventLoop eventLoop, ExistsSequenceListener listener, BatchPolicy policy, Key[] keys) {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean[] exists(BatchPolicy policy, Key[] keys) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public boolean exists(Policy policy, Key key) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void get(EventLoop eventLoop, BatchListListener listener, BatchPolicy policy, List<BatchRead> records) {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void get(EventLoop eventLoop, BatchSequenceListener listener, BatchPolicy policy, List<BatchRead> records) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
		
	@Trace
	public void get(EventLoop eventLoop, RecordListener listener, Policy policy, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
		
	@Trace
	public void get(EventLoop eventLoop, RecordListener listener, Policy policy, Key key, String... binNames) throws AerospikeException {	
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void get(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public Record[] get(BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record[] get(BatchPolicy policy, Key[] keys, String... binNames) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void put(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void put(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void prepend(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void prepend(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void truncate(InfoPolicy policy, String ns, String set, Calendar beforeLastUpdate) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void touch(WritePolicy policy, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void touch(EventLoop eventLoop, WriteListener listener, WritePolicy policy, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record get(Policy policy, Key key) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record get(Policy policy, Key key, String... binNames) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record getHeader(Policy policy, Key key) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(EventLoop eventLoop, RecordListener listener, Policy policy, Key key) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(BatchPolicy policy, List<BatchRead> records) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void get(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record[] getHeader(BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(EventLoop eventLoop, RecordArrayListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void getHeader(EventLoop eventLoop, RecordSequenceListener listener, BatchPolicy policy, Key[] keys) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public Record operate(WritePolicy policy, Key key, Operation... operations) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void operate(EventLoop eventLoop, RecordListener listener, WritePolicy policy, Key key, Operation... operations) throws AerospikeException {
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
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void scanAll(EventLoop eventLoop, RecordSequenceListener listener, ScanPolicy policy, String namespace, String setName, String... binNames) throws AerospikeException {
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
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public LargeList getLargeList(WritePolicy policy, Key key, String binName) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public LargeMap getLargeMap(WritePolicy policy, Key key, String binName, String userModule) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public LargeSet getLargeSet(WritePolicy policy, Key key, String binName, String userModule) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public LargeStack getLargeStack(WritePolicy policy, Key key, String binName, String userModule) {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public RegisterTask register(Policy policy, String clientPath, String serverPath, Language language) 
		throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public RegisterTask register(Policy policy, ClassLoader resourceLoader, String resourcePath, String serverPath, Language language) 
		throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public RegisterTask registerUdfString(Policy policy, String code, String serverPath, Language language) 
		throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void removeUdf(InfoPolicy policy, String serverPath) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public RecordSet query(QueryPolicy policy, Statement statement) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}
	
	@Trace
	public void query(EventLoop eventLoop, RecordSequenceListener listener, QueryPolicy policy, Statement statement) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public RecordSet queryNode(QueryPolicy policy, Statement statement, Node node) throws AerospikeException {
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
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public ResultSet queryAggregate(QueryPolicy policy, Statement statement) throws AerospikeException {
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public ResultSet queryAggregateNode(QueryPolicy policy, Statement statement, Node node) throws AerospikeException {
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
		try {
			return Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}

	@Trace
	public void dropIndex(Policy policy,String namespace, String setName,String indexName) throws AerospikeException {
		try {
			Weaver.callOriginal();
		} catch(AerospikeException e) {
			NewRelic.noticeError(e);
			throw e;
		}
	}


}
