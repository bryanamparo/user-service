/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service.core;

import com.electronicscience.ws.model.User;

/**
 * Object representation of JSON request.
 * 
 * @author Lino Cervantes
 */
public class ServiceRequest {

	private User user;
	private String username;
	private String password;

	/**
	 * Construct <code>ServiceRequest</code> object.
	 */
	public ServiceRequest() {
	}

	/**
	 * Returns the user.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
