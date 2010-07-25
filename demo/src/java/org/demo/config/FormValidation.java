package org.demo.config;

import org.gigue.FormValidationBase;
import org.gigue.Form;

public class FormValidation extends FormValidationBase {

	public void signGuestbook(Form form) {
		form.field("name").label("name").actionTrim().ruleRequired().ruleMaxLength(50);
		form.field("comments").label("comments").actionTrim();
	}
}

