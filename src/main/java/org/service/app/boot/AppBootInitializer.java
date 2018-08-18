package org.service.app.boot;

import org.service.app.annotations.Bean;
import org.service.app.annotations.Inject;
import org.service.app.contracts.boot.InitApp;
import org.service.app.contracts.config.AppConfiguration;
import org.service.app.logger.Logger;

@Bean
public class AppBootInitializer implements InitApp {

	@Inject
	private AppConfiguration configuration;

	public void init() {
		configuration.load();
		Logger.info("App initialized.");
	}

}
