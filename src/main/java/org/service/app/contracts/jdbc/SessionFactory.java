package org.service.app.contracts.jdbc;

/**
 * This interface will allow to abstract the internal implementation used for JPA by this project so in future we can move to any other implementations.
 * @author Anish
 *
 */

public interface SessionFactory extends org.hibernate.SessionFactory{

	
	
}
