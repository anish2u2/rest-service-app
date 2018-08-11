package org.service.app.boot;

import org.service.app.contracts.boot.InitApp;
import org.service.app.logger.Logger;

public class AppBootInitializer implements InitApp {

	public void init() {
		
		Logger.info("App initialized.");
	}

}
