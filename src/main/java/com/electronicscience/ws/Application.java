/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws;

import static spark.Spark.*;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.electronicscience.ws.service.DeleteUserByIdService;
import com.electronicscience.ws.service.GetUserByIdService;
import com.electronicscience.ws.service.GetUserService;
import com.electronicscience.ws.service.LoginService;
import com.electronicscience.ws.service.UpsertUserService;
import com.electronicscience.ws.util.Jndi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.servlet.SparkApplication;

/**
 * The entry point of the application.
 * 
 * @author Lino Cervantes
 */
public class Application implements SparkApplication {

	@Override
	public void init() {
		Gson gson = new GsonBuilder().create();
		Logger logger = Logger.getLogger("ws");
		DataSource dataSource = Jndi.from("jdbc/training");

		// Get all users.
		get("/", new GetUserService(gson, logger, dataSource), gson::toJson);

		// Get user by ID.
		get("/:id", new GetUserByIdService(gson, logger, dataSource), gson::toJson);

		// Delete user by ID.
		delete("/:id", new DeleteUserByIdService(gson, logger, dataSource), gson::toJson);

		// Insert or update user.
		post("/", "application/json;charset=UTF-8", new UpsertUserService(gson, logger, dataSource), gson::toJson);
		
		//Login
		post("/login", "application/json;charset=UTF-8", new LoginService(gson, logger, dataSource), gson::toJson);
	}
}
