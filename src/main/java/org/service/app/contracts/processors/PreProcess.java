package org.service.app.contracts.processors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interface allows method for pre-processing the request.
 * 
 * @author Anish
 *
 */
public interface PreProcess extends Processors {

	/**
	 * This method allow to per- intercept request.
	 * 
	 * @param request
	 * @param response
	 * @param exception
	 * @throws Exception
	 */
	public void preProcess(HttpServletRequest request, HttpServletResponse response, Exception exception)
			throws Exception;

}
