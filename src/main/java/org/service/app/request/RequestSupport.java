package org.service.app.request;

/**
 * This class will allow methods to support requests.
 * 
 * @author Anish
 *
 */
public class RequestSupport {

	/**
	 * Allow to check that requested uri is having @param extension.
	 * 
	 * @param requestUri
	 * @param extention
	 * @return true or false.
	 */
	public static final boolean isExtentionsMatched(String requestUri, String[] extension) {
		for (String ext : extension) {
			if (requestUri.endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

}
