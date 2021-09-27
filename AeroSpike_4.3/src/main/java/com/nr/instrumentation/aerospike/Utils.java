package com.nr.instrumentation.aerospike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.aerospike.client.BatchRead;
import com.aerospike.client.Key;
import com.aerospike.client.query.Statement;
import com.newrelic.api.agent.DatastoreParameters;

public class Utils {

	public static DatastoreParameters getParams(Key key, String operation) {
		String ns = key.namespace;
		String setName = key.setName != null ? key.setName : "Unknown";
		return DatastoreParameters.product("AeroSpike").collection(setName).operation(operation).noInstance().databaseName(ns).build();
	}
	
	public static DatastoreParameters getParams(String setName, String ns, String operation) {
		return DatastoreParameters.product("AeroSpike").collection(setName).operation(operation).noInstance().databaseName(ns).build();
	}
	
	public static DatastoreParameters getParams(Key[] keys, String operation) {
		HashSet<String> namespaces = new HashSet<String>();
		ArrayList<String> keyNames = new ArrayList<String>();
		for(Key key : keys) {
			namespaces.add(key.namespace);
			keyNames.add(key.setName != null ? key.setName : "Unknown");
		}
		
		return DatastoreParameters.product("AeroSpike").collection(String.join(",", keyNames)).operation(operation).noInstance().databaseName(String.join(",", namespaces)).build();
	}
	
	public static DatastoreParameters getParams(List<BatchRead> records, String operation) {
		
		HashSet<String> namespaces = new HashSet<String>();
		ArrayList<String> keyNames = new ArrayList<String>();
		for(BatchRead record : records) {
			Key key = record.key;
			namespaces.add(key.namespace);
			keyNames.add(key.setName != null ? key.setName : "Unknown");
		}
		
		return DatastoreParameters.product("AeroSpike").collection(String.join(",", keyNames)).operation(operation).noInstance().databaseName(String.join(",", namespaces)).build();
	}
	
	public static DatastoreParameters getParams(Statement statement, String operation) {
		String setName = statement.getSetName();
		String tableName = null;
		String packName = statement.getPackageName();
		String funcName = statement.getFunctionName();
		if(setName != null && !setName.isEmpty()) {
			StringBuffer sb = new StringBuffer(setName);
			if(packName != null) {
				sb.append('-');
				sb.append(packName);
			}
			if(funcName != null) {
				sb.append('-');
				sb.append(funcName);
			}
			tableName = sb.toString();
		} else {
			StringBuffer sb = new StringBuffer("Unknown");
			if(packName != null) {
				sb.append('-');
				sb.append(packName);
			}
			if(funcName != null) {
				sb.append('-');
				sb.append(funcName);
			}
			tableName = sb.toString();
		}
		
		return DatastoreParameters.product("AeroSpike").collection(tableName).operation(operation).noInstance().databaseName(statement.getNamespace()).build();
	}

	public static DatastoreParameters getParams(Statement statement, String packageName, String functionName, String operation) {
		String setName = statement.getSetName();
		String tableName = null;
		String packName = packageName != null ? packageName : statement.getPackageName();
		String funcName = functionName != null ? functionName : statement.getFunctionName();
		if(setName != null && !setName.isEmpty()) {
			StringBuffer sb = new StringBuffer(setName);
			if(packName != null) {
				sb.append('-');
				sb.append(packName);
			}
			if(funcName != null) {
				sb.append('-');
				sb.append(funcName);
			}
			tableName = sb.toString();
		} else {
			StringBuffer sb = new StringBuffer("Unknown");
			if(packName != null) {
				sb.append('-');
				sb.append(packName);
			}
			if(funcName != null) {
				sb.append('-');
				sb.append(funcName);
			}
			tableName = sb.toString();
		}
		
		return DatastoreParameters.product("AeroSpike").collection(tableName).operation(operation).noInstance().databaseName(statement.getNamespace()).build();
	}
	
	
	public static void reportStatement(HashMap<String,Object> attributes, Statement statement) {
		reportValue(attributes,"FunctionName",statement.getFunctionName());
		reportValue(attributes,"IndexName",statement.getIndexName());
		reportValue(attributes,"Namespace",statement.getNamespace());
		reportValue(attributes,"PackageName",statement.getPackageName());
		reportValue(attributes,"Resourcepath",statement.getResourcePath());
		reportValue(attributes,"SetName",statement.getSetName());
	}
	
	public static void reportValue(HashMap<String,Object> attributes, String key, Object value) {
		if(key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}


}
