package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Represents config file location.
 * 
 * @author Anish
 *
 */

public class ConfigFileLoc {

	@XmlAttribute(name = "file")
	private String loc;

}
