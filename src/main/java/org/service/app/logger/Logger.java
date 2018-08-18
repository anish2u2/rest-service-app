package org.service.app.logger;

import org.service.app.annotations.Bean;

@Bean
public class Logger {

	private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("App-Logger");

	public static void info(String message) {
		logger.info(message);
	}

}
