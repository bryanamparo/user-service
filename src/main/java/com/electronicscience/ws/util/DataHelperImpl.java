/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of <code>DataHelper</code> interface.
 * 
 * @author Lino Cervantes
 */
class DataHelperImpl extends DataHelper {

	private final Connection con;

	/**
	 * Instantiate <code>DataHelperImpl</code> object.
	 * 
	 * @param con the database connection
	 */
	DataHelperImpl(Connection con) {
		this.con = con;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> query(String sql, SqlParameter[] parameters, RowMapper mapper) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			assignStatementParameters(stmt, parameters);
			try (ResultSet rs = stmt.executeQuery()) {
				List<T> list = new ArrayList<>();
				while (rs.next()) {
					list.add((T) mapper.mapRow(rs));
				}
				return list;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryOne(String sql, SqlParameter[] parameters, RowMapper mapper) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			assignStatementParameters(stmt, parameters);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next() ? (T) mapper.mapRow(rs) : null;
			}
		}
	}

	@Override
	public Double queryForDouble(String sql, SqlParameter[] parameters) throws SQLException {
		Object result = queryForObject(sql, parameters);
		return result != null ? Double.parseDouble(result.toString()) : null;
	}

	@Override
	public Integer queryForInt(String sql, SqlParameter[] parameters) throws SQLException {
		Object result = queryForObject(sql, parameters);
		return result != null ? Integer.parseInt(result.toString()) : null;
	}

	@Override
	public Object queryForObject(String sql, SqlParameter[] parameters) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			assignStatementParameters(stmt, parameters);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next() ? rs.getObject(1) : null;
			}
		}
	}

	@Override
	public String queryForString(String sql, SqlParameter[] parameters) throws SQLException {
		Object result = queryForObject(sql, parameters);
		return result != null ? result.toString() : null;
	}

	@Override
	public boolean execute(String sql, SqlParameter[] parameters) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			assignStatementParameters(stmt, parameters);
			return stmt.execute();
		}
	}

	/**
	 * Assigns statement parameters.
	 * 
	 * @param stmt a prepared statement
	 * @param parameters array of parameters
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	private void assignStatementParameters(PreparedStatement stmt, SqlParameter[] parameters) throws SQLException {
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				stmt.setObject(i + 1, parameters[i].getValue(), parameters[i].getType());
			}
		}
	}
}
