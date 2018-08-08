package org.service.app.annotations;

/**
 * This will represents as Controller for the app classes.
 * 
 * @author Anish
 *
 */
public @interface Controller {
	
	/**
	 * This will return the mapping url for the controller.
	 * @return
	 */
	String value();
	
	/**
	 * Name of the controller.
	 * @return
	 */
	String name() default "NULL";
}
