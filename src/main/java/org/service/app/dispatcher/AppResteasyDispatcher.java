package org.service.app.dispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class AppResteasyDispatcher extends HttpServletDispatcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 134865L;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		super.init(servletConfig);
	}

	@Override
	public void destroy() {

		super.destroy();
	}
}
