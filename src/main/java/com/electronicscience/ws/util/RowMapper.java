/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Lino Cervantes
 */
@FunctionalInterface
public interface RowMapper {

	/**
	 * Maps the data of the current row in the <code>ResultSet</code> to an
	 * object.
	 * 
	 * @param rs <code>ResultSet</code> object
	 * @return the mapped object
	 * @throws SQLException if a database access error occurs or this method is
	 * called on a closed connection
	 */
	Object mapRow(ResultSet rs) throws SQLException;
}
