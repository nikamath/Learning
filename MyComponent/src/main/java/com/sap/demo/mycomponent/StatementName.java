package com.sap.demo.mycomponent;

public class StatementName {

	private DBTableName dbTableName;

	public DBTableName getDbTableName() {
		return dbTableName;
	}

	public void setDbTableName(DBTableName dbTableName) {
		this.dbTableName = dbTableName;
	}

	public StatementName(DBTableName dbTableName) {
		super();
		this.dbTableName = dbTableName;
	}

	public StatementName() {
		super();
	}

}
