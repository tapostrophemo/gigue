package org.demo.controllers;

import org.gigue.Controller;
import org.gigue.Gigue;
import org.demo.Guestbook;

public class Site extends Controller {

	private Guestbook guestbook;

	public Site() {
		super.Guestbook();
		guestbook = new Guestbook();
	}

	public void index() {
		this.load.view("guestList", Gigue.array("guests", guestbook.getGuests()));
	}

	public void signGuestbook() {
		if (!this.formValidation().run("signGuestbook")) {
			this.load.view("guestbookForm");
		} else {
			guestbook.saveSignature(this.input.post("name"), this.input.post("comments"));
			this.session.setFlashdata("message", "Thanks for signing the guestbook.");
			redirect();
		}
	}
}

