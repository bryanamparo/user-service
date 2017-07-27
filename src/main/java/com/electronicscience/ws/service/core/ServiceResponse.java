/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service.core;

import java.util.List;

import com.electronicscience.ws.model.User;

/**
 * Object representation of JSON response.
 * 
 * @author Lino Cervantes
 */
public class ServiceResponse {

	private String message;
	private String error;
	private List<User> users;

	/**
	 * Construct <code>ServiceResponse</code> object.
	 */
	public ServiceResponse() {
	}

	/**
	 * Instantiate <code>ServiceResponse</code> object with error message.
	 * 
	 * @param error message when error has occurred
	 */
	public ServiceResponse(String error) {
		this.error = error;
	}

	/**
	 * Returns the message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the error message.
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error message.
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Returns the list of users.
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Sets the list of users.
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
