package org.service.app.config;

import org.service.app.annotations.Bean;
import org.service.app.contracts.config.AppConfiguration;

@Bean
public class AppConfigInitializer implements AppConfiguration {

	private String configFileName;

	public void setConfig(String configFileName) {
		this.configFileName = configFileName;
	}

	public void load() {

	}

	public void stop() {

	}

	public void clean() {

	}

}
