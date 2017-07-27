/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.electronicscience.ws.model.User;
import com.electronicscience.ws.util.DataHelper;
import com.electronicscience.ws.util.SqlParameter;

/**
 * Data access object for <code>User</code> class.
 * 
 * @author Lino Cervantes
 */
public class UserDao {

	/**
	 * Default Value: {@value}
	 */
	private static final String FIND_ALL_SQL = "SELECT id, username, password, email, first_name, last_name, status, modified_by FROM user";

	/**
	 * Default Value: {@value}
	 */
	private static final String FIND_BY_ID_SQL = "SELECT id, username, password, email, first_name, last_name, status, modified_by FROM user WHERE id=?";

	/**
	 * Default Value: {@value}
	 */
	private static final String INSERT_SQL = "INSERT INTO user (username, password, email, first_name, last_name, status, modified_by, modified_date) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

	/**
	 * Default Value: {@value}
	 */
	private static final String UPDATE_SQL = "UPDATE user SET username=?, password=?, email=?, first_name=?, last_name=?, status=?, modified_by=?, modified_date=NOW() WHERE id=?";

	/**
	 * Default Value: {@value}
	 */
	private static final String DELETE_BY_ID_SQL = "DELETE FROM user WHERE id=?";

	private final DataHelper dataHelper;

	/**
	 * Construct <code>UserDao</code> object.
	 * 
	 * @param con the database connection
	 */
	public UserDao(Connection con) {
		dataHelper = DataHelper.getDefault(con);
	}

	/**
	 * Returns the list of users.
	 * 
	 * @return the list of users
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public List<User> findAll() throws SQLException {
		return dataHelper.query(FIND_ALL_SQL, null, (rs) -> {
			User user = new User();
			user.setId(rs.getInt(User.ID));
			user.setUsername(rs.getString(User.USERNAME));
			user.setPassword(rs.getString(User.PASSWORD));
			user.setEmail(rs.getString(User.EMAIL));
			user.setFirstName(rs.getString(User.FIRST_NAME));
			user.setLastName(rs.getString(User.LAST_NAME));
			user.setStatus(rs.getString(User.STATUS));
			user.setModifiedBy(rs.getString(User.MODIFIED_BY));
			return user;
		});
	}

	/**
	 * Returns a user based on the supplied ID.
	 * 
	 * @param id of the user
	 * @return the <code>User</code> object
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public User findById(int id) throws SQLException {
		SqlParameter[] parameters = { new SqlParameter(id, Types.INTEGER) };
		return dataHelper.queryOne(FIND_BY_ID_SQL, parameters, (rs) -> {
			User user = new User();
			user.setId(rs.getInt(User.ID));
			user.setUsername(rs.getString(User.USERNAME));
			user.setPassword(rs.getString(User.PASSWORD));
			user.setEmail(rs.getString(User.EMAIL));
			user.setFirstName(rs.getString(User.FIRST_NAME));
			user.setLastName(rs.getString(User.LAST_NAME));
			user.setStatus(rs.getString(User.STATUS));
			user.setModifiedBy(rs.getString(User.MODIFIED_BY));
			return user;
		});
	}

	/**
	 * Inserts the user.
	 * 
	 * @param user the <code>User</code> object
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public void insert(User user) throws SQLException {
		SqlParameter[] parameters = {
				new SqlParameter(user.getUsername(), Types.VARCHAR),
				new SqlParameter(user.getPassword(), Types.VARCHAR),
				new SqlParameter(user.getEmail(), Types.VARCHAR),
				new SqlParameter(user.getFirstName(), Types.VARCHAR),
				new SqlParameter(user.getLastName(), Types.VARCHAR),
				new SqlParameter(user.getStatus(), Types.VARCHAR),
				new SqlParameter(user.getModifiedBy(), Types.VARCHAR) };
		dataHelper.execute(INSERT_SQL, parameters);
	}

	/**
	 * Updates the user.
	 * 
	 * @param user the <code>User</code> object
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public void update(User user) throws SQLException {
		SqlParameter[] parameters = {
				new SqlParameter(user.getUsername(), Types.VARCHAR),
				new SqlParameter(user.getPassword(), Types.VARCHAR),
				new SqlParameter(user.getEmail(), Types.VARCHAR),
				new SqlParameter(user.getFirstName(), Types.VARCHAR),
				new SqlParameter(user.getLastName(), Types.VARCHAR),
				new SqlParameter(user.getStatus(), Types.VARCHAR),
				new SqlParameter(user.getModifiedBy(), Types.VARCHAR),
				new SqlParameter(user.getId(), Types.INTEGER) };
		dataHelper.execute(UPDATE_SQL, parameters);
	}

	/**
	 * Deletes the user by ID.
	 * 
	 * @param id the user ID
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public void deleteById(int id) throws SQLException {
		SqlParameter[] parameters = { new SqlParameter(id, Types.INTEGER) };
		dataHelper.execute(DELETE_BY_ID_SQL, parameters);
	}
}
