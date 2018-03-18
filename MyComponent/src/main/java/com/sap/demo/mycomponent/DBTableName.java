package com.sap.demo.mycomponent;

import java.util.List;

public class DBTableName {

	private Action action;
	private String table;
	private List<Access> accesses;
	private List<Key> keys;

	public enum Action {
		SELECT, UPDATE, DELETE, INSERT
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public List<Access> getAccess() {
		return accesses;
	}

	public void setAccess(List<Access> access) {
		this.accesses = access;
	}

	public List<Key> getKeys() {
		return keys;
	}

	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}

	public DBTableName(Action action, String table, List<Access> access, List<Key> keys) {
		super();
		this.action = action;
		this.table = table;
		this.accesses = access;
		this.keys = keys;
	}

	public DBTableName() {
		super();
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public List<Access> getAccesses() {
		return accesses;
	}

	public void setAccesses(List<Access> accesses) {
		this.accesses = accesses;
	};

}
