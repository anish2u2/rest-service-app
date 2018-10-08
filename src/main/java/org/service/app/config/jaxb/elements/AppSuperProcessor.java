package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AppSuperProcessor {

	private String superProcessorKlas;

	private AppProcessorRegistrar registrar;

	private String methodType;

	public String getSuperProcessorKlas() {
		return superProcessorKlas;
	}

	@XmlAttribute(name = "class")
	public void setSuperProcessorKlas(String superProcessorKlas) {
		this.superProcessorKlas = superProcessorKlas;
	}

	public AppProcessorRegistrar getRegistrar() {
		return registrar;
	}

	@XmlElement(name = "register-processor-type")
	public void setRegistrar(AppProcessorRegistrar registrar) {
		this.registrar = registrar;
	}

	public String getMethodType() {
		return methodType;
	}

	@XmlElement(name = "method-type")
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

}
