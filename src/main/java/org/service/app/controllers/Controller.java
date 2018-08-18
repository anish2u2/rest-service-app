package org.service.app.controllers;

import org.service.app.annotations.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.service.app.annotations.Controller
@RequestMapping(value = "/home.html")
public class Controller {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		System.out.println("Returning home.");
		return "index";
	}

}
