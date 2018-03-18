package com.sap.demo.mycomponent;

public class ColumnValue {

	private String column;
	private String value;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ColumnValue(String column, String value) {
		super();
		this.column = column;
		this.value = value;
	}

	public ColumnValue() {
		super();
	}
}
