package org.service.app.contracts.jaxb;

public interface Reader {

	public Object read(String fileName, Class<?> targetClass);

}
