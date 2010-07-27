package org.demo.config;

import org.gigue.framework.Form;
import org.gigue.framework.FormValidationBase;

public class FormValidation extends FormValidationBase {

	public void signGuestbook(Form form) {
		form.field("name", "Name").trim().required().maxLength(50);
		form.field("comments", "Comments").trim();
	}
}
