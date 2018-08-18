package org.service.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This will be used for qualifying the name or identifying the class object.
 * 
 * @author Anish
 *
 */
@Inherited
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.beans.factory.annotation.Qualifier
public @interface Qualifier {

}
