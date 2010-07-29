package org.gigue.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = -4329372903985945995L;
	
	String applicationPackage;
	String defaultControllerClass;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// TODO: test me!!!
		this.applicationPackage = config.getInitParameter("application.package");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		respond(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		respond(req, resp);
	}

	private void respond(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String requestURI = req.getRequestURI();
		String contextPath = getServletContext().getContextPath();
		requestURI = stripContextPath(requestURI, contextPath);
		resp.getWriter().println(req.getMethod() +
				"<br> contextPath=" + contextPath +
				"<br> originalRequestURI=" + req.getRequestURI() +
				"<br> requestURL=" + req.getRequestURL() +
				"<br> class=" + getRouteClassName(requestURI) + 
				"<br> method=" + getRouteMethodName(requestURI) +
				"<br> args=" + getRouteArguments(requestURI));
	}

	String stripContextPath(String requestURI, String contextPath) {
		String stripped = requestURI;
		if (requestURI.startsWith(contextPath)) {
			stripped = requestURI.substring(contextPath.length());
		}
		if ("".equals(stripped)) {
			stripped = "/";
		}
		return stripped;
	}

	String getRouteClassName(String requestURI) {
		String name = requestURI;
		if (name.startsWith("/")) { // won't the requestURI always have a '/' prepended?
			name = name.substring(1);
		}
		if ("".equals(name)) {
			return applicationPackage + "." + defaultControllerClass;
		}
		
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		int indexOfSlash = name.indexOf("/");
		if (indexOfSlash > 0) {
			name = name.substring(0, indexOfSlash);
		}
		return applicationPackage + "." + name;
	}

	String getRouteMethodName(String requestURI) {
		String method = requestURI;
		if (method.startsWith("/")) {
			method = method.substring(1);
		}
		String[] parts = method.split("/");
		if (parts.length <= 1) {
			return "index";
		}
		return parts[1];
	}
	
	List<String> getRouteArguments(String requestURI) {
		ArrayList<String> argList = new ArrayList<String>();
		String argString = requestURI;
		if (argString.startsWith("/")) {
			argString = argString.substring(1);
		}
		String[] parts = argString.split("/");
		if (parts.length > 2) {
			int i = 2;
			while (i < parts.length) {
				argList.add(parts[i]);
				i++;
			}
		}
		return argList;
	}
}
