/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service.core;

/**
 * @author Lino Cervantes
 */
@SuppressWarnings("serial")
public class ClientException extends Exception {

	/**
	 * Construct <code>ClientException</code>.
	 */
	public ClientException() {
	}

	/**
	 * Construct <code>ClientException</code> with error message.
	 * 
	 * @param message error message
	 */
	public ClientException(String message) {
		super(message);
	}
}
