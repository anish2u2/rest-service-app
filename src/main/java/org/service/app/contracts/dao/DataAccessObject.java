package org.service.app.contracts.dao;

import java.sql.Connection;

import org.service.app.contracts.jdbc.SessionFactory;

/**
 * This interface will provide methods to access to the actual {@SessionFactory or Connection } objects.
 * 
 * @author Anish
 *
 */

public interface DataAccessObject {

	/**
	 * Sets the connection.
	 * 
	 * @param connection
	 */
	
	public void setConnection(Connection connection);
	
	/**
	 * Sets the SessionFactory objects.
	 * @param sessionfactory
	 */
	public void setSessionFactory(SessionFactory sessionfactory);
	
	/**
	 * Returns the SessionFactory object associated with this app.
	 * @return sessionFactory or null.
	 */
	public SessionFactory getSessionFactory();
	
	
	/**
	 * Returns the Connection object associated with this app.
	 * @return connection or null.
	 */
	public Connection getConnection();

}
