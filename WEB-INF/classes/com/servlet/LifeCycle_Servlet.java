package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycle_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public LifeCycle_Servlet() {
		System.out.println("LifeCycle_Servlet->default...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycle_Servlet->init...");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle_Servlet->service...");
	}
	
	/*
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle_Servlet->doGet...");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle_Servlet->doPost...");
	}
	*/
	
	@Override
	public void destroy() {
		System.out.println("LifeCycle_Servlet->destroy...");
	}
	
}
