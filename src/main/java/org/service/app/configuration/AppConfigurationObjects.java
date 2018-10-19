package org.service.app.configuration;

import org.service.app.config.jaxb.elements.AppFilterConfig;
import org.service.app.config.jaxb.elements.AppInitConfig;
import org.service.app.config.jaxb.elements.AppProcessorConfig;
import org.service.app.config.jaxb.elements.MvcControllersConfig;

public class AppConfigurationObjects {

	private static AppConfigurationObjects appConfigurationObjects;

	private AppInitConfig appInitConfig;

	private AppFilterConfig appFilterConfiguration;

	private MvcControllersConfig appMvcControllersConfig;

	private AppProcessorConfig appProcessorConfig;

	private AppConfigurationObjects() {
		if (appConfigurationObjects != null) {
			throw new RuntimeException("Object already exists.");
		}
	}

	public static AppConfigurationObjects getAppConfigurationObjects() {
		if (appConfigurationObjects == null) {
			appConfigurationObjects = new AppConfigurationObjects();
		}
		return appConfigurationObjects;
	}

	public AppFilterConfig getAppFilterConfiguration() {
		return appFilterConfiguration;
	}

	public void setAppFilterConfiguration(AppFilterConfig appFilterConfiguration) {
		this.appFilterConfiguration = appFilterConfiguration;
	}

	public MvcControllersConfig getAppMvcControllersConfig() {
		return appMvcControllersConfig;
	}

	public void setAppMvcControllersConfig(MvcControllersConfig appMvcControllersConfig) {
		this.appMvcControllersConfig = appMvcControllersConfig;
	}

	public AppProcessorConfig getAppProcessorConfig() {
		return appProcessorConfig;
	}

	public void setAppProcessorConfig(AppProcessorConfig appProcessorConfig) {
		this.appProcessorConfig = appProcessorConfig;
	}

	public AppInitConfig getAppInitConfig() {
		return appInitConfig;
	}

	public void setAppInitConfig(AppInitConfig appInitConfig) {
		this.appInitConfig = appInitConfig;
	}

	public AppConfigurationObjects getAppConfigObjectReference() {
		return this;
	}

	public static void destroySingleton() {
		AppConfigurationObjects.appConfigurationObjects = null;
	}
}
