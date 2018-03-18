package com.sap.demo.mycomponent;

import java.util.List;

public class Access {
	private List<ColumnValue> columnValues;

	public List<ColumnValue> getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(List<ColumnValue> columnValues) {
		this.columnValues = columnValues;
	}

	public Access(List<ColumnValue> columnValues) {
		super();
		this.columnValues = columnValues;
	}

	public Access() {
		super();
	}
	
}
