package org.demo.controllers;

import org.demo.models.Guestbook;
import org.gigue.Controller;

public class Site extends Controller {

	private Guestbook guestbook;

	public Site() {
		super();
		guestbook = new Guestbook();
	}

	public void index() {
//		this.load.view("guestList", GigueUtil.array("guests", guestbook.getGuests()));
	}

	public void signGuestbook() {
//		if (!this.formValidation().run("signGuestbook")) {
//			this.load.view("guestbookForm");
//		} else {
//			guestbook.saveSignature(this.input.post("name"), this.input.post("comments"));
			guestbook.saveSignature("name", "comments");
//			this.session.setFlashdata("message", "Thanks for signing the guestbook.");
//			redirect();
//		}
	}
}

