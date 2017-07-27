/*
 * Copyright (C) 2017 E-Science Corporation
 */
package com.electronicscience.ws.util;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author Lino Cervantes
 */
public abstract class Jndi {

	@SuppressWarnings("unchecked")
	public static <T> T from(String name) {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			return (T) envContext.lookup(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
