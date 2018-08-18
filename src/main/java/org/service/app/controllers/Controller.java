package org.service.app.controllers;

import org.service.app.annotations.RequestMapping;
import org.service.app.annotations.RequestMapping.RequestType;

@org.service.app.annotations.Controller
@RequestMapping(value = "/home.html")
public class Controller {

	@RequestMapping(method = RequestType.GET)
	public String home() {
		System.out.println("Returning home.");
		return "index";
	}

}
