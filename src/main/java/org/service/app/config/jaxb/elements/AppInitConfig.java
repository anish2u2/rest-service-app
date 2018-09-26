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

	private String version;

	private ConfigFileLoc filterConfigLoc;

	private ConfigFileLoc processorConfigLoc;

	private ConfigFileLoc mvcControllerConfig;

	public String getVersion() {
		return version;
	}
	
	@XmlAttribute(name = "version")
	public void setVersion(String version) {
		this.version = version;
	}

	public ConfigFileLoc getFilterConfigLoc() {
		return filterConfigLoc;
	}
	
	@XmlElement(name = "filter-config")
	public void setFilterConfigLoc(ConfigFileLoc filterConfigLoc) {
		this.filterConfigLoc = filterConfigLoc;
	}

	public ConfigFileLoc getProcessorConfigLoc() {
		return processorConfigLoc;
	}
	
	@XmlElement(name = "processor-config")
	public void setProcessorConfigLoc(ConfigFileLoc processorConfigLoc) {
		this.processorConfigLoc = processorConfigLoc;
	}

	public ConfigFileLoc getMvcControllerConfig() {
		return mvcControllerConfig;
	}
	
	@XmlElement(name = "mvc-controllers-config")
	public void setMvcControllerConfig(ConfigFileLoc mvcControllerConfig) {
		this.mvcControllerConfig = mvcControllerConfig;
	}

}
