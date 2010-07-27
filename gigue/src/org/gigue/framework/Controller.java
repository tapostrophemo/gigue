package org.gigue.framework;


/**
 * Similar to CodeIgniter in approach/architecture, different in:
 * 1. does not require Loader to load classes (hello, JVM)
 * 2. does not worry about backwards compatability (goodbye, PHP4)
 * 3. database access allowed only in Models
 * 4. ...
 */
public class Controller {
	
	protected Loader load;
	protected FormValidationBase formValidation;
	protected Input input;
	protected Session session;
	
	public void redirect(String uri, String method, int httpResponseCode) {
	}
	
	public void redirect(String uri, String method) {
//		redirect(uri, method, 302);
	}
	
	public void redirect(String uri) {
//		redirect(uri, "location", 302);
	}
	
	public void redirect() {
//		redirect("", "location", 302);
	}
}
