/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service;

import java.sql.Connection;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.electronicscience.ws.dao.UserDao;
import com.electronicscience.ws.model.User;
import com.electronicscience.ws.service.core.AbstractService;
import com.electronicscience.ws.service.core.ClientException;
import com.electronicscience.ws.service.core.ServiceRequest;
import com.electronicscience.ws.service.core.ServiceResponse;
import com.google.gson.Gson;

/**
 * @author Lino Cervantes
 */
public class UpsertUserService extends AbstractService {

	public UpsertUserService(Gson gson, Logger logger, DataSource dataSource) {
		super(gson, logger, dataSource);
	}

	@Override
	public ServiceResponse process(Map<String, String> params, ServiceRequest serviceRequest) throws Exception {
		ServiceResponse serviceResponse = new ServiceResponse();
		try (Connection con = dataSource.getConnection()) {
			User user = serviceRequest.getUser();
			if (user == null) {
				throw new ClientException("There is no user to insert/update");
			}
			UserDao userDao = new UserDao(con);
			userDao.insert(user);			
		}
		return serviceResponse;
	}
}
