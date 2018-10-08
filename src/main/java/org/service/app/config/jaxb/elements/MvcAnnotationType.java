package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * This will represents MVC Annotation type for controller config.
 * 
 * @author Anish
 *
 */
public class MvcAnnotationType {

	private String annotationType;

	public String getAnnotationType() {
		return annotationType;
	}

	@XmlAttribute(name = "annotation-class")
	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}

}
