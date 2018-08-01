package org.service.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/home.html")
public class Controller {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		System.out.println("Returning home.");
		return "index";
	}

}
