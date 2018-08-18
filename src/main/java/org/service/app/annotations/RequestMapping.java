package org.service.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Inherited
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.web.bind.annotation.RequestMapping
public @interface RequestMapping {
	
	
	RequestMethod[] method() default RequestMethod.GET;

	@AliasFor(value = "path")
	String[] value() default "";

	@AliasFor(value = "value")
	String[] path() default "";
}
