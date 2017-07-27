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
}
