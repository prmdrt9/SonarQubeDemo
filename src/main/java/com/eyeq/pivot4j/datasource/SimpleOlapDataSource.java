/*
 * ====================================================================
 * This software is subject to the terms of the Common Public License
 * Agreement, available at the following URL:
 *   http://www.opensource.org/licenses/cpl.html .
 * You must accept the terms of that agreement to use this software.
 * ====================================================================
 */
package com.eyeq.pivot4j.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.olap4j.OlapConnection;
import org.olap4j.OlapWrapper;

public class SimpleOlapDataSource extends AbstractOlapDataSource {

	private String connectionString;

	private Properties connectionProperties;

	/**
	 * @return the connectionString
	 */
	public String getConnectionString() {
		return connectionString;
	}

	/**
	 * @param connectionString
	 *            the connectionString to set
	 */
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	/**
	 * @return the connectionProperties
	 */
	public Properties getConnectionProperties() {
		return connectionProperties;
	}

	/**
	 * @param connectionProperties
	 *            the connectionProperties to set
	 */
	public void setConnectionProperties(Properties connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

	/**
	 * @throws SQLException
	 * @see com.eyeq.pivot4j.datasource.AbstractOlapDataSource#createConnection(java
	 *      .lang.String, java.lang.String)
	 */
	@Override
	protected OlapConnection createConnection(String username, String password)
			throws SQLException {
		Connection connection = DriverManager
				.getConnection(getConnectionString());
		OlapWrapper wrapper = (OlapWrapper) connection;

		return wrapper.unwrap(OlapConnection.class);
	}
}