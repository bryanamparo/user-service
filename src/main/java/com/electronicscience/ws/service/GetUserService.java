/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service;

import java.sql.Connection;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.electronicscience.ws.dao.UserDao;
import com.electronicscience.ws.service.core.AbstractService;
import com.electronicscience.ws.service.core.ServiceRequest;
import com.electronicscience.ws.service.core.ServiceResponse;
import com.google.gson.Gson;

/**
 * @author Lino Cervantes
 */
public class GetUserService extends AbstractService {

	public GetUserService(Gson gson, Logger logger, DataSource dataSource) {
		super(gson, logger, dataSource);
	}

	@Override
	public ServiceResponse process(Map<String, String> params, ServiceRequest request) throws Exception {
		ServiceResponse serviceResponse = new ServiceResponse();
		try (Connection con = dataSource.getConnection()) {
			UserDao userDao = new UserDao(con);
			serviceResponse.setMessage("OK");
			serviceResponse.setUsers(userDao.findAll());
		}
		return serviceResponse;
	}
}
