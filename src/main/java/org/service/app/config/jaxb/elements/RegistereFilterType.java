package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

public class RegistereFilterType {

	private String klasType;

	public String getKlasType() {
		return klasType;
	}

	@XmlAttribute(name = "class-type")
	public void setKlasType(String klasType) {
		this.klasType = klasType;
	}

}
