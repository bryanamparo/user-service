/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service.core;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import spark.Request;
import spark.Response;

/**
 * Abstract implementation of <code>Service</code>.
 * 
 * @author Lino Cervantes
 */
public abstract class AbstractService implements Service {

	protected final Logger logger;
	protected final DataSource dataSource;
	protected final Gson gson;

	/**
	 * Construct <code>AbstractService</code> with <code>Gson</code>,
	 * <code>Logger</code>, and <code>DataSource</code>.
	 * 
	 * @param gson <code>Gson</code> object
	 * @param logger <code>Logger</code> object
	 * @param dataSource <code>DataSource</code> object
	 */
	public AbstractService(Gson gson, Logger logger, DataSource dataSource) {
		this.gson = gson;
		this.logger = logger;
		this.dataSource = dataSource;
	}

	@Override
	public Object handle(Request request, Response response) throws Exception {
		response.type("application/json;charset=UTF-8");
		ServiceRequest serviceRequest;
		ServiceResponse serviceResponse;
		try {
			try {
				serviceRequest = gson.fromJson(request.body(), ServiceRequest.class);
			} catch (JsonParseException e) {
				throw new ClientException("Invalid JSON format");
			}
			serviceResponse = process(request.params(), serviceRequest);
			serviceResponse.setMessage("OK");
			response.status(200);
		} catch (ClientException e) {
			serviceResponse = new ServiceResponse(e.getMessage());
			response.status(400);
		} catch (Exception e) {
			serviceResponse = new ServiceResponse("Internal error");
			response.status(500);
			logger.error("Internal error", e);
		}
		return serviceResponse;
	}
}
