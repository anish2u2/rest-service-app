package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * This will represents Mvc Controller registrar config.
 * 
 * @author Anish
 *
 */
public class MvcControllersRegistrar {

	private String className;

	public String getClassName() {
		return className;
	}

	@XmlAttribute(name = "class")
	public void setClassName(String className) {
		this.className = className;
	}

}
