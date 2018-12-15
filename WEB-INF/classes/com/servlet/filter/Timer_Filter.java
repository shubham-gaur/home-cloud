package com.servlet.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Timer_Filter implements Filter {
	
	private FilterConfig config = null;
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		String name = "";
		if (request instanceof HttpServletRequest) {
			name = ((HttpServletRequest)request).getRequestURI();
		}
		config.getServletContext().log(name + ": " + (after - before) + "ms");
	}

	public void destroy() {
		config = null;
	}
	
}
