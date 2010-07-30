package org.gigue.web;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class RouterTest {
	
	private Router router;
	
	@Before
	public void setUp() {
		router = new Router();
		router.applicationPackage = "org.demo";
	}
	
	@Test
	public void itShouldStripContextPath() {
		assertThat(router.stripContextPath("/context", "/context"), is(equalTo("/")));
		assertThat(router.stripContextPath("/context/", "/context"), is(equalTo("/")));
		assertThat(router.stripContextPath("/context/name", "/context"), is(equalTo("/name")));
	}
	
	@Test
	public void itShouldGetRouteClassName() {
		assertThat(router.getRouteClassName("/name"), is(equalTo("org.demo.Name")));
		assertThat(router.getRouteClassName("/name/method"), is(equalTo("org.demo.Name")));
		assertThat(router.getRouteClassName("/name/method/arg"), is(equalTo("org.demo.Name")));
	}
	
	@Test
	public void itShouldGetDefaultRouteMethodName() {
		assertThat(router.getRouteMethodName("/name"), is(equalTo("index")));
	}
	
	@Test
	public void itShouldGetRouteMethodName() {
		assertThat(router.getRouteMethodName("/name/method"), is(equalTo("method")));
		assertThat(router.getRouteMethodName("/name/method/arg"), is(equalTo("method")));
	}
	
	@Test
	public void itShouldGetNoRouteArguments() {
		assertThat(router.getRouteArguments("/name").size(), is(equalTo(0)));
		assertThat(router.getRouteArguments("/name/method").size(), is(equalTo(0)));
	}
	
	@Test
	public void itShouldGetSingleRouteArgument() {
		List<String> routeArguments = router.getRouteArguments("/name/method/arg");
		assertThat(routeArguments.size(), is(equalTo(1)));
		assertThat(routeArguments.get(0), is(equalTo("arg")));
	}
	
	@Test
	public void itShouldGetMultipleRouteArguments() {
		List<String> routeArguments = router.getRouteArguments("/name/method/arg1/arg2");
		assertThat(routeArguments.size(), is(equalTo(2)));
		assertThat(routeArguments.get(0), is(equalTo("arg1")));
		assertThat(routeArguments.get(1), is(equalTo("arg2")));
	}

	// TODO: advanced cases involve parsing out path params and looking up routes config
	//
	// (default.controller.class=DefaultController) / => DefaultController.index()
	// (route.alt./=AltController[/]) /alt => AltController.index()
	// ...?
	
	@Test
	public void itShouldUseDefaultControllerClassWhenNoNameSpecified() {
		router.defaultControllerClass = "Default";
		assertThat(router.getRouteClassName("/"), is(equalTo("org.demo.Default")));
	}
}
