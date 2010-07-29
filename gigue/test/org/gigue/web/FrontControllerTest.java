package org.gigue.web;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class FrontControllerTest {

	private FrontController frontController;;
	
	@Before
	public void setUp() {
		frontController = new FrontController();
		frontController.applicationPackage = "org.demo";
	}
	
	@Test
	public void itShouldGetClassName() {
		assertThat(frontController.getRouteClassName("/name"), is(equalTo("org.demo.Name")));
		assertThat(frontController.getRouteMethodName("/name"), is(equalTo("index")));
		assertThat(frontController.getRouteArguments("/name").size(), is(equalTo(0)));
	}
	
	@Test
	public void itShouldGetClassNameMethodName() {
		assertThat(frontController.getRouteClassName("/name/method"), is(equalTo("org.demo.Name")));
		assertThat(frontController.getRouteMethodName("/name/method"), is(equalTo("method")));
		assertThat(frontController.getRouteArguments("/name/method").size(), is(equalTo(0)));
	}
	
	@Test
	public void itShouldGetClassNameMethodNameArgs() {
		assertThat(frontController.getRouteClassName("/name/method/arg"), is(equalTo("org.demo.Name")));
		assertThat(frontController.getRouteMethodName("/name/method/arg"), is(equalTo("method")));
		List<String> routeArguments = frontController.getRouteArguments("/name/method/arg");
		assertThat(routeArguments.size(), is(equalTo(1)));
		assertThat(routeArguments.get(0), is(equalTo("arg")));
	}
	
	@Test
	public void itShouldStripContextPath() {
		assertThat(frontController.stripContextPath("/context", "/context"), is(equalTo("/")));
		assertThat(frontController.stripContextPath("/context/", "/context"), is(equalTo("/")));
		assertThat(frontController.stripContextPath("/context/name", "/context"), is(equalTo("/name")));
	}
	
	// TODO: advanced cases involve parsing out path params and looking up routes config
	//
	// (default.controller.class=DefaultController) / => DefaultController.index()
	// (route.alt./=AltController[/]) /alt => AltController.index()
	// ...?
	
	@Test
	public void itShouldUseDefaultControllerClassWhenNoNameSpecified() {
		frontController.defaultControllerClass = "Default";
		assertThat(frontController.getRouteClassName("/"), is(equalTo("org.demo.Default")));
	}
}
