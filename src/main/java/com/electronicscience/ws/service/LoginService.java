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
import com.electronicscience.ws.service.core.ClientException;
import com.electronicscience.ws.service.core.ServiceRequest;
import com.electronicscience.ws.service.core.ServiceResponse;
import com.google.gson.Gson;

public class LoginService extends AbstractService{
	
	public LoginService (Gson gson, Logger logger, DataSource dataSource) {
		super(gson, logger, dataSource);
	}
	
	@Override
	public ServiceResponse process(Map<String, String> params, ServiceRequest serviceRequest) throws Exception {
		ServiceResponse serviceResponse = new ServiceResponse();
		try (Connection con = dataSource.getConnection()){
//			String username = params.get("username");
//			String password = params.get("password");
			
//			User u = serviceRequest.getUser();
//			String username = u.getUsername();
//			String password = u.getPassword();
			List<User> users = new ArrayList<User>();
			String username = serviceRequest.getUsername();
			String password = serviceRequest.getPassword();
			Logger logger = Logger.getLogger(LoginService.class);
			logger.info("username: " + username + " password: "+ password);
			
			if (username == null || username.isEmpty()) {
				throw new ClientException("Please specify username");
			}
			if (password == null || password.isEmpty()) {
				throw new ClientException("Please specify password");
			}
			
			UserDao userDao = new UserDao(con);
			User user = userDao.login(username, password);
			if (user != null) {
				users.add(user);
			}
			else {
				throw new ClientException("Username/password does not match");
			}
			serviceResponse.setUsers(users);
		}
		return serviceResponse;
	}

}
