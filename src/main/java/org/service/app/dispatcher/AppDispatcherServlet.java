package org.service.app.dispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.app.config.jaxb.elements.AppInitConfig;
import org.service.app.contracts.boot.InitApp;
import org.service.app.logger.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This dispatcher servlet will be used to
 * 
 * @author Anish
 *
 */

public class AppDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13534634L;

	private AppInitConfig appInitConfig;

	private InitApp appInitializer;

	/*
	 * { appInitializer = new AppBootInitializer(); }
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		appInitializer = WebApplicationContextUtils.findWebApplicationContext(config.getServletContext())
				.getBean(InitApp.class);
		Logger.info("Dispatcher Servlet Initialized..");
		Logger.info("Now initializing App Configurations.");
		appInitializer.init();
		Logger.info("initialization done.");
	}

	@Override
	protected void onRefresh(ApplicationContext context) {
		super.onRefresh(context);
	}

	@Override
	protected void initStrategies(ApplicationContext context) {
		super.initStrategies(context);
	}

	@Override
	protected void doDispatch(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		super.doDispatch(arg0, arg1);
	}

	@Override
	protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.noHandlerFound(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
