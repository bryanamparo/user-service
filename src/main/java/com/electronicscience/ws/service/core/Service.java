/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service.core;

import java.util.Map;

import spark.Route;

/**
 * Service interface.
 * 
 * @author Lino Cervantes
 */
public interface Service extends Route {

	/**
	 * Performs service process.
	 * 
	 * @param params URL parameters
	 * @param serviceRequest <code>ServiceRequest</code> object
	 * @return <code>ServiceResponse</code> object
	 */
	ServiceResponse process(Map<String, String> params, ServiceRequest serviceRequest) throws Exception;
}
