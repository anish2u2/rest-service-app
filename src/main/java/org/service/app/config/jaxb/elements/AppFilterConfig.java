package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This will represents App filter config.
 * 
 * @author Anish
 *
 */
@XmlRootElement(name = "filter-config")
public class AppFilterConfig {
	
	
	private String version;
	
	private AppFilterManager manager;

	public AppFilterManager getManager() {
		return manager;
	}
	@XmlElement(name = "super-filter-class")
	public void setManager(AppFilterManager manager) {
		this.manager = manager;
	}

	public String getVersion() {
		return version;
	}
	
	@XmlAttribute(name="version")
	public void setVersion(String version) {
		this.version = version;
	} 
	
}
