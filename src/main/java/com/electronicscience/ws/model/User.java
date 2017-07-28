/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.model;

import com.google.gson.annotations.SerializedName;

/**
 * Object representation of user table.
 * 
 * @author Lino Cervantes
 */
public class User {

	/**
	 * Default Value: {@value}
	 */
	public static final String ID = "id";

	/**
	 * Default Value: {@value}
	 */
	public static final String USERNAME = "username";

	/**
	 * Default Value: {@value}
	 */
	public static final String PASSWORD = "password";

	/**
	 * Default Value: {@value}
	 */
	public static final String EMAIL = "email";

	/**
	 * Default Value: {@value}
	 */
	public static final String FIRST_NAME = "first_name";

	/**
	 * Default Value: {@value}
	 */
	public static final String LAST_NAME = "last_name";

	/**
	 * Default Value: {@value}
	 */
	public static final String STATUS = "status";

	/**
	 * Default Value: {@value}
	 */
	public static final String MODIFIED_BY = "modified_by";

	private int id;
	private String username;
	private String password;
	private String email;
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
	private String lastName;
	private String status;
	@SerializedName("modified_by")
	private String modifiedBy;

	/**
	 * Construct <code>User</code> object.
	 */
	public User() {
	}

	/**
	 * Returns the ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the e-mail.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the e-mail.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the modifier.
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modifier.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
