package org.gigue.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = -4329372903985945995L;
	
	String applicationPackage;
	
	private Router router;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationPackage = config.getInitParameter("application.package");
		router.setApplicationPackage(applicationPackage);
	}
	
	public FrontController() {
		this.router = new Router();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		respond(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		respond(req, resp);
	}

	private void respond(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String requestURI = request.getRequestURI();
		String contextPath = getServletContext().getContextPath();
		requestURI = router.stripContextPath(requestURI, contextPath);
		response.getWriter().println(request.getMethod() +
				"<br> contextPath=" + contextPath +
				"<br> originalRequestURI=" + request.getRequestURI() +
				"<br> requestURL=" + request.getRequestURL() +
				"<br> class=" + router.getRouteClassName(requestURI) + 
				"<br> method=" + router.getRouteMethodName(requestURI) +
				"<br> args=" + router.getRouteArguments(requestURI));
	}
}
