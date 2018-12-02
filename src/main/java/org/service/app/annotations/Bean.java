package org.service.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * This will represents bean annotation for creating beans for the app
 * container.
 * 
 * @author Anish
 *
 */
@Inherited
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Bean {

	/**
	 * This will indicate the bean id for registering with
	 * application/webapplication context.
	 * 
	 * @return
	 */
	// @AliasFor(value = "value")
	String value() default "";

}
