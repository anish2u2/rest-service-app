package org.service.app.logger;

public class Logger {

	private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("App-Logger");

	public static void info(String message) {
		logger.info(message);
	}

}
