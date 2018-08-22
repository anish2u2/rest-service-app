package org.service.app.contracts.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AppFilter {

	public void init(FilterConfig config);

	public void loadConfig();

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain);

	public void destroy();

	public String[] getSupportedExtensions();

}
