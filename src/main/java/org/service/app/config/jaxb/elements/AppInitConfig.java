package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This will represents App init config.
 * 
 * @author Anish
 *
 */
@XmlRootElement(name = "init-app-config")
public class AppInitConfig {

	@XmlAttribute(name = "version")
	private String version;

	@XmlElement(name = "filter-config")
	private ConfigFileLoc filterConfigLoc;

	@XmlElement(name = "processor-config")
	private ConfigFileLoc processorConfigLoc;

	@XmlElement(name = "mvc-controllers-config")
	private ConfigFileLoc mvcControllerConfig;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ConfigFileLoc getFilterConfigLoc() {
		return filterConfigLoc;
	}

	public void setFilterConfigLoc(ConfigFileLoc filterConfigLoc) {
		this.filterConfigLoc = filterConfigLoc;
	}

	public ConfigFileLoc getProcessorConfigLoc() {
		return processorConfigLoc;
	}

	public void setProcessorConfigLoc(ConfigFileLoc processorConfigLoc) {
		this.processorConfigLoc = processorConfigLoc;
	}

	public ConfigFileLoc getMvcControllerConfig() {
		return mvcControllerConfig;
	}

	public void setMvcControllerConfig(ConfigFileLoc mvcControllerConfig) {
		this.mvcControllerConfig = mvcControllerConfig;
	}

}
