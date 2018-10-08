package org.service.app.config.jaxb.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This will represents App processors config.
 * 
 * @author Anish
 *
 */
@XmlRootElement(name = "processor-config")
public class AppProcessorConfig {

	private String version;

	private AppSuperProcessor superPreProcessor;

	private AppSuperProcessor superPostProcessor;

	public String getVersion() {
		return version;
	}

	@XmlAttribute(name = "version")
	public void setVersion(String version) {
		this.version = version;
	}

	public AppSuperProcessor getSuperPreProcessor() {
		return superPreProcessor;
	}

	@XmlElement(name = "super-pre-processor")
	public void setSuperPreProcessor(AppSuperProcessor superPreProcessor) {
		this.superPreProcessor = superPreProcessor;
	}

	public AppSuperProcessor getSuperPostProcessor() {
		return superPostProcessor;
	}

	@XmlElement(name = "super-post-processor")
	public void setSuperPostProcessor(AppSuperProcessor superPostProcessor) {
		this.superPostProcessor = superPostProcessor;
	}

}
