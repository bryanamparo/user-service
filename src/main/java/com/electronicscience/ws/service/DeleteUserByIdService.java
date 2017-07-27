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
public class DeleteUserByIdService extends AbstractService {

	public DeleteUserByIdService(Gson gson, Logger logger, DataSource dataSource) {
		super(gson, logger, dataSource);
	}

	@Override
	public ServiceResponse process(Map<String, String> params, ServiceRequest serviceRequest) throws Exception {
		ServiceResponse serviceResponse = new ServiceResponse();
		try (Connection con = dataSource.getConnection()) {
			int id = Integer.parseInt(params.get(":id"));
			UserDao userDao = new UserDao(con);
			userDao.deleteById(id);
		}
		return serviceResponse;
	}
}
