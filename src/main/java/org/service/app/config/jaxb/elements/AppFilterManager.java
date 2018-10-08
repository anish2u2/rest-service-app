package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AppFilterManager {

	
	private String klas;

	private String urlPattern;

	private RegistereFilterType filterType;
	
	
	public RegistereFilterType getFilterType() {
		return filterType;
	}
	@XmlElement(name="register-filter-type")
	public void setFilterType(RegistereFilterType filterType) {
		this.filterType = filterType;
	}
	
	
	public String getUrlPattern() {
		return urlPattern;
	}
	@XmlElement(name = "url-pattern")
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getKlas() {
		return klas;
	}
	@XmlAttribute(name = "class")
	public void setKlas(String klas) {
		this.klas = klas;
	}

}
