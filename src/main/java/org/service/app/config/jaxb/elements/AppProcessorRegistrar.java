package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

public class AppProcessorRegistrar {

	private String registerKlasType;

	public String getRegisterKlasType() {
		return registerKlasType;
	}

	@XmlAttribute(name = "class-type")
	public void setRegisterKlasType(String registerKlasType) {
		this.registerKlasType = registerKlasType;
	}

}
