package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This will represents App MVC controllers config.
 * 
 * @author Anish
 *
 */
@XmlRootElement(name = "mvc-controller-config")
public class MvcControllersConfig {

	private String version;

	private MvcControllersRegistrar registrar;

	private MvcAnnotationType annotationType;

	public String getVersion() {
		return version;
	}

	@XmlAttribute(name = "version")
	public void setVersion(String version) {
		this.version = version;
	}

	public MvcControllersRegistrar getRegistrar() {
		return registrar;
	}

	@XmlElement(name = "mvc-controller-registrar")
	public void setRegistrar(MvcControllersRegistrar registrar) {
		this.registrar = registrar;
	}

	public MvcAnnotationType getAnnotationType() {
		return annotationType;
	}

	@XmlElement(name = "mvc-annotation-type")
	public void setAnnotationType(MvcAnnotationType annotationType) {
		this.annotationType = annotationType;
	}

}
