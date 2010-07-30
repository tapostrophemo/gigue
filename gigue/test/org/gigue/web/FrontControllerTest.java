package org.gigue.web;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.ServletConfig;

import org.junit.Before;
import org.junit.Test;


public class FrontControllerTest {

	private FrontController frontController;;
	
	@Before
	public void setUp() {
		frontController = new FrontController();
	}
	
	@Test
	public void itShouldReadApplicationPackageOnInit() throws Exception {
		frontController = new FrontController();
		ServletConfig config = mock(ServletConfig.class);
		when(config.getInitParameter("application.package")).thenReturn("app.package.name");
		
		assertThat(frontController.applicationPackage, is(nullValue()));
		frontController.init(config);
		assertThat(frontController.applicationPackage, is(equalTo("app.package.name")));
	}
}
