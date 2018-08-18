package org.service.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RequestMapping {

	enum RequestType {
		GET, POST, HEAD, TRACE, DELETE, PUT, OPTION
	}

	RequestType method() default RequestType.GET;

	String value() default "NULL";

}
