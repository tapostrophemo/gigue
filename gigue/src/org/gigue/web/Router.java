package org.gigue.web;

import java.util.ArrayList;
import java.util.List;

public class Router {
	
	String applicationPackage;
	String defaultControllerClass;
	
	public void setApplicationPackage(String applicationPackage) {
		this.applicationPackage = applicationPackage;
	}
	
	public String stripContextPath(String requestURI, String contextPath) {
		String stripped = requestURI;
		if (requestURI.startsWith(contextPath)) {
			stripped = requestURI.substring(contextPath.length());
		}
		if ("".equals(stripped)) {
			stripped = "/";
		}
		return stripped;
	}
	
	public String getRouteMethodName(String requestURI) {
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
	
	public List<String> getRouteArguments(String requestURI) {
		List<String> argList = new ArrayList<String>();
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

	public String getRouteClassName(String requestURI) {
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
}
