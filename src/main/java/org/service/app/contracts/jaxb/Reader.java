package org.service.app.contracts.jaxb;

/**
 * This method will allow methods to read xml configurations.
 * 
 * @author Anish
 *
 */
public interface Reader {

	/**
	 * This method will read xml file passed as fileName param and return the target
	 * class object type, if the the target class not assignable then it will throw
	 * exception.
	 * 
	 * @param fileName
	 * @param targetClass
	 * @return
	 */
	public Object read(String fileName, Class<?> targetClass) throws Exception;

}
