package org.service.app.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.service.app.annotations.Bean;
import org.service.app.contracts.jaxb.Reader;

@Bean
public class XmlReader implements Reader {

	private static Reader reader;

	private XmlReader() {

	}
	
	public static Reader getReader() {
		if (reader == null) {
			reader = new XmlReader();
		}

		return reader;
	}

	public Object read(String fileName, Class<?> targetClass) throws Exception {
		JAXBContext context = JAXBContext.newInstance(targetClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return unmarshaller.unmarshal(new File(fileName));
	}

}
