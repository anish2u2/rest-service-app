package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents config file location.
 * 
 * @author Anish
 *
 */

public class ConfigFileLoc {

	private String loc;

	public String getLoc() {
		return loc;
	}
	@XmlAttribute(name = "file")
	public void setLoc(String loc) {
		this.loc = loc;
	}

}
