/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.electronicscience.ws.dao.UserDao;
import com.electronicscience.ws.model.User;
import com.electronicscience.ws.service.core.AbstractService;
import com.electronicscience.ws.service.core.ServiceRequest;
import com.electronicscience.ws.service.core.ServiceResponse;
import com.google.gson.Gson;

/**
 * @author Lino Cervantes
 */
public class GetUserByIdService extends AbstractService {

	public GetUserByIdService(Gson gson, Logger logger, DataSource dataSource) {
		super(gson, logger, dataSource);
	}

	@Override
	public ServiceResponse process(Map<String, String> params, ServiceRequest request) throws Exception {
		ServiceResponse serviceResponse = new ServiceResponse();
		try (Connection con = dataSource.getConnection()) {
			int id = Integer.parseInt(params.get(":id"));
			List<User> users = new ArrayList<>();
			UserDao userDao = new UserDao(con);
			User user = userDao.findById(id); 
			if (user != null) {
				users.add(user);
			}
			serviceResponse.setUsers(users);
		}
		return serviceResponse;
	}
}
