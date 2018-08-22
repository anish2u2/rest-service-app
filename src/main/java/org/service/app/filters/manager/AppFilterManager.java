package org.service.app.filters.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.app.contracts.filter.AppFilter;
import org.service.app.logger.Logger;
import org.service.app.request.RequestSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AppFilterManager implements Filter {

	private Collection<AppFilter> appFilters;

	public void destroy() {
		Logger.info("Destroying filters.");
		if (appFilters != null)
			for (AppFilter appFilter : appFilters) {
				appFilter.destroy();
			}
		Logger.info("Removing all registered filters.");
		appFilters.clear();
		Logger.info("Filteres are removed ready for GC.");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		AppFilterChain filterChain = new AppFilterChain(chain);
		for (AppFilter filter : appFilters) {
			if (RequestSupport.isExtentionsMatched(((HttpServletRequest) servletRequest).getRequestURI(),
					filter.getSupportedExtensions())) {
				filterChain.addFilters(filter);
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		Logger.info("Initializing filters.");
		Map<String, AppFilter> appFilter = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBeansOfType(AppFilter.class);
		Logger.info("Registering filteres.");
		appFilters = appFilter.values();
		Logger.info("Initializing registered Filters.");
		for (AppFilter filter : appFilters) {
			filter.loadConfig();
			filter.init(filterConfig);
		}
		Logger.info("All filteres are initialized.");
	}

	public class AppFilterChain implements FilterChain {

		private FilterChain filterChain;

		private List<AppFilter> filteres = new ArrayList<AppFilter>();

		private Iterator<AppFilter> iterator;

		public AppFilterChain(FilterChain chain) {
			this.filterChain = chain;
		}

		public void doFilter(ServletRequest arg0, ServletResponse arg1) throws IOException, ServletException {
			if (null == iterator) {
				iterator = filteres.iterator();
			}
			if (iterator.hasNext()) {
				iterator.next().doFilter((HttpServletRequest) arg0, (HttpServletResponse) arg1, this);
			} else {
				filterChain.doFilter(arg0, arg1);
			}
		}

		public List<AppFilter> getFilteres() {
			return filteres;
		}

		public void addFilters(AppFilter filter) {
			filteres.add(filter);
		}

		public void setFilteres(List<AppFilter> filteres) {
			this.filteres = filteres;
		}

	}
}
