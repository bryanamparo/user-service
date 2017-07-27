/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * This interface is intended to simplify database operations.
 * 
 * @author Lino Cervantes
 */
public abstract class DataHelper {

	/**
	 * Returns a list of objects based from the result set.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @param mapper object or functional interface that implements the data
	 * assignment instructions
	 * @return a list of objects based from the result set
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract <T> List<T> query(String sql, SqlParameter[] parameters, RowMapper mapper) throws SQLException;

	/**
	 * Returns a single object.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @param mapper object or functional interface that implements the data
	 * assignment instructions
	 * @return a single object from the query. it is NULL if none found
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract <T> T queryOne(String sql, SqlParameter[] parameters, RowMapper mapper) throws SQLException;

	/**
	 * Returns a <code>Double</code> value.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @return a <code>Double</code> value. it is NULL if none found
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract Double queryForDouble(String sql, SqlParameter[] parameters) throws SQLException;

	/**
	 * Returns an <code>Integer</code> value.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @return an <code>Integer</code> value. it is NULL if none found
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract Integer queryForInt(String sql, SqlParameter[] parameters) throws SQLException;

	/**
	 * Returns an <code>Object</code> value.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @return an <code>Object</code> value. it is NULL if none found
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract Object queryForObject(String sql, SqlParameter[] parameters) throws SQLException;

	/**
	 * Returns a <code>String</code> value.
	 * 
	 * @param sql in-line query
	 * @param parameters for filtering
	 * @return a <code>String</code> value. it is NULL if none found
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract String queryForString(String sql, SqlParameter[] parameters) throws SQLException;

	/**
	 * Executes a non-query statement.
	 * 
	 * @param sql a non-query statement
	 * @param parameters for data assignment or filtering
	 * @return true if the execution is successful. otherwise, false
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	public abstract boolean execute(String sql, SqlParameter[] parameters) throws SQLException;

	/**
	 * Returns an instance of <code>DataHelper</code>.
	 * 
	 * @param con the database connection
	 * @return <code>DataHelper</code> instance
	 */
	public static DataHelper getDefault(Connection con) {
		return new DataHelperImpl(con);
	}
}
