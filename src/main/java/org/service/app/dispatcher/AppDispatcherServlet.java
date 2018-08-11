package org.service.app.dispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.app.boot.AppBootInitializer;
import org.service.app.contracts.boot.InitApp;
import org.service.app.logger.Logger;
import org.springframework.context.ApplicationContext;
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

	private InitApp appInitializer;

	{
		appInitializer = new AppBootInitializer();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		Logger.info("Dispatcher Servlet Initialized..");
		Logger.info("Now initializing App Configurations.");
		appInitializer.init();
		Logger.info("initialization done.");
	}

	@Override
	protected void onRefresh(ApplicationContext context) {
		// TODO Auto-generated method stub
		super.onRefresh(context);
	}

	@Override
	protected void initStrategies(ApplicationContext context) {
		// TODO Auto-generated method stub
		super.initStrategies(context);
	}

	@Override
	protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.noHandlerFound(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
