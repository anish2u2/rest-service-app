package org.service.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * This will represents a resource in the app when it will be applied to any
 * class.
 * 
 * @author Anish
 *
 */
@Target(value = ElementType.TYPE)
public @interface Resources {

	/**
	 * Provided versions.
	 */
	String VERSION[] = { "V0.1", "V1.0" };

	/**
	 * This will return the version of the resource.
	 * 
	 * @return
	 */
	String version();

}
