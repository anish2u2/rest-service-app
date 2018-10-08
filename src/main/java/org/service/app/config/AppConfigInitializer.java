package org.service.app.config;

import java.util.Locale;

import org.service.app.annotations.Bean;
import org.service.app.annotations.Inject;
import org.service.app.config.jaxb.elements.AppFilterConfig;
import org.service.app.config.jaxb.elements.AppInitConfig;
import org.service.app.config.jaxb.elements.AppProcessorConfig;
import org.service.app.config.jaxb.elements.ConfigFileLoc;
import org.service.app.config.jaxb.elements.MvcControllersConfig;
import org.service.app.contracts.config.AppConfiguration;
import org.service.app.contracts.jaxb.Reader;
import org.service.app.jaxb.XmlReader;
import org.service.app.util.AppThreadLocal;
import org.service.app.util.MessageBundle;

@Bean
public class AppConfigInitializer implements AppConfiguration {

	private static final String INIT_CONFIG_FILE = "app.boot.init.config.file.location";

	@Inject
	private MessageBundle messages;

	private Reader reader;

	private String configFileName;

	{
		reader = XmlReader.getReader();
	}

	public void setConfig(String configFileName) {
		this.configFileName = configFileName;
	}

	public void load() {
		if (configFileName == null) {
			readConfigFileName();
		}
		try {
			AppThreadLocal.getAppThreadLocal().put(APP_CONFIGS, reader.read(configFileName, AppInitConfig.class));
			loadConfigComponents((AppInitConfig) AppThreadLocal.getAppThreadLocal().getObject(APP_CONFIGS));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadConfigComponents(AppInitConfig appConfig) {
		ConfigFileLoc filterConfigs = appConfig.getFilterConfigLoc();
		ConfigFileLoc processorConfig = appConfig.getProcessorConfigLoc();
		ConfigFileLoc mvcControllersConfig = appConfig.getMvcControllerConfig();
		try {
			AppFilterConfig filtersConfig = (AppFilterConfig) reader.read(filterConfigs.getLoc(),
					AppFilterConfig.class);
			AppThreadLocal.getAppThreadLocal().put(APP_FILTER_CONFIG, filtersConfig);
			AppThreadLocal.getAppThreadLocal().put(APP_MVC_CONFIG,
					(MvcControllersConfig) reader.read(mvcControllersConfig.getLoc(), MvcControllersConfig.class));
			AppThreadLocal.getAppThreadLocal().put(APP_PROCESSOR_CONFIG,
					(AppProcessorConfig) reader.read(processorConfig.getLoc(), AppProcessorConfig.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop() {

	}

	public void clean() {

	}

	public void register() {

	}

	private void readConfigFileName() {
		configFileName = messages.getMessage(INIT_CONFIG_FILE, null, Locale.ENGLISH);
	}
}
