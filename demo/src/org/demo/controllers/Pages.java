package org.demo.controllers;

import org.gigue.framework.Controller;

public class Pages extends Controller {

	public void about() {
		this.load.view("pages/about");
	}
	
	public void contact() {
		this.load.view("pages/contact");
	}
}
