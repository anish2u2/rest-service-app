package org.service.app.controllers;

import org.service.app.annotations.Get;

@org.service.app.annotations.Controller
public class Controller {

	@Get(value = "/home.html")
	public String home() {

		return "index";
	}

}
