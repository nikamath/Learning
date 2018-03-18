package com.sap.demo.mycomponent;

import java.util.List;

public class Key {

	private Operation compareOperation = Operation.EQ;
	private List<ColumnValue> columnValues;

	public enum Operation {
		EQ("="), NEQ("!="), LT("<"), LTEQ("<="), GT(">"), GTEQ(">="), LIKE("like");

		private String operand;

		private Operation(String operand) {
			this.operand = operand;
		}

		public String getOperand() {
			return operand;
		}
		
	};

	public List<ColumnValue> getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(List<ColumnValue> columnValues) {
		this.columnValues = columnValues;
	}

	public Key(List<ColumnValue> columnValues) {
		super();
		this.columnValues = columnValues;
	}

	public Key() {
		super();
	}

	public Operation getCompareOperation() {
		return compareOperation;
	}

	public void setCompareOperation(Operation compareOperation) {
		this.compareOperation = compareOperation;
	}
	
}
