package org.service.app.config;

import java.util.Locale;

import org.service.app.annotations.Bean;
import org.service.app.annotations.Inject;
import org.service.app.config.jaxb.elements.AppInitConfig;
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
			AppThreadLocal.getAppThreadLocal().put("configInstance", reader.read(configFileName, AppInitConfig.class));
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
