package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * This will represents MVC Annotation type for controller config.
 * 
 * @author Anish
 *
 */
public class MvcAnnotationType {

	@XmlAttribute(name = "annotation-class")
	private String annotationType;

	public String getAnnotationType() {
		return annotationType;
	}

	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}

}
