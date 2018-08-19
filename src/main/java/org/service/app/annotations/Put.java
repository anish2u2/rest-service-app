package org.service.app.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This annotation will allow to register controllers for put method request.
 * 
 * @author Anish
 *
 */

@Target(value = { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.PUT)
public @interface Put {

	String name() default "";

	@AliasFor(annotation = RequestMapping.class)
	String[] value() default {};

	@AliasFor(annotation = RequestMapping.class)
	String[] path() default {};

	@AliasFor(annotation = RequestMapping.class)
	String[] params() default {};

	@AliasFor(annotation = RequestMapping.class)
	String[] headers() default {};

	@AliasFor(annotation = RequestMapping.class)
	String[] consumes() default {};

	@AliasFor(annotation = RequestMapping.class)
	String[] produces() default {};
}
