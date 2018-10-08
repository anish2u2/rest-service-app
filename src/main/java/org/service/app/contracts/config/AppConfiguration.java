package org.service.app.contracts.config;

/**
 * This interface allow methods to work on app confiurations.
 * 
 * @author Anish
 *
 */
public interface AppConfiguration {

	public String APP_CONFIGS = "APP_CONFIG_INSTANCE";

	public String APP_FILTER_CONFIG = "APP_FILTER_CONFIG_INSTANCE";

	public String APP_MVC_CONFIG = "APP_MVC_CONFIG_INSTANCE";

	public String APP_PROCESSOR_CONFIG = "APP_PROCESSOR_CONFIG_INSTANCE";

	/**
	 * sets the configuration file.
	 * 
	 * @param configFileName
	 */
	public void setConfig(String configFileName);

	/**
	 * Loads the configuration file into app.
	 */
	public void load();

	/**
	 * Registered the configuration with the app.
	 */
	public void register();

	/**
	 * Stop loading the configuration.
	 */
	public void stop();

	/**
	 * clean-up the configured objects.
	 */
	public void clean();

}
