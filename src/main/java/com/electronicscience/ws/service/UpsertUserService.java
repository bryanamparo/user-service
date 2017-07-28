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
		Logger logger = Logger.getLogger(UpsertUserService.class);
		try (Connection con = dataSource.getConnection()) {
			User user = serviceRequest.getUser();
			if (user == null) {
				throw new ClientException("There is no user to insert/update");
			}
			else {
				// VALIDATE ALL FIELDS
				// CHECK IF USERNAME IS UNIQUE
				UserDao userDao = new UserDao(con);
				logger.info("user id: " + user.getId());
				
				User withSameUser = null;
				if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null || user.getModifiedBy() == null
						|| user.getPassword() == null || user.getStatus() == null || user.getUsername() == null 
						|| user.getEmail().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty() 
						|| user.getModifiedBy().isEmpty() || user.getPassword().isEmpty() || user.getStatus().isEmpty() 
						|| user.getUsername().isEmpty()) {
					throw new ClientException("Kindly fill up all fields");
				}
				else {
					withSameUser = userDao.findByUsernameAndEmail(user.getUsername(), user.getEmail());		
					
					if (withSameUser != null && (withSameUser.getId() != user.getId())) {
						logger.info("witSameUser is not null, id: " + withSameUser.getId() + " user: " + user.getId());
						if (user.getUsername().equalsIgnoreCase(withSameUser.getUsername())) {
							throw new ClientException("Username already exists");
						}
						else if (user.getEmail().equalsIgnoreCase(withSameUser.getEmail())) {
							throw new ClientException("Email already exists");
						}
					}
					else { //valid user!
						if (user.getId() > 0) { //update user!
							userDao.update(user);
						}
						else { //new user!
							userDao.insert(user);
						}
					}
				}
			}		
		}
		return serviceResponse;
	}
}
