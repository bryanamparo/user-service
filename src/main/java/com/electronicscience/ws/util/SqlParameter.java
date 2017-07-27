/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.util;

/**
 * An object that holds the value and type of the SQL parameter.
 * 
 * @author Lino Cervantes
 */
public class SqlParameter {

	private Object value;
	private int type;

	/**
	 * Instantiate <code>SqlParameter</code> object.
	 */
	public SqlParameter() {
	}

	/**
	 * Instantiate <code>SqlParameter</code> object with value and type.
	 * 
	 * @param value the value of the parameter
	 * @param type the type of the parameter
	 */
	public SqlParameter(Object value, int type) {
		this.value = value;
		this.type = type;
	}

	/**
	 * Returns the value.
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Returns the type.
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the type.
	 */
	public void setType(int type) {
		this.type = type;
	}
}
