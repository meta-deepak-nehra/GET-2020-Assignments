package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName ="/filter", urlPatterns={"/vehicleRegistration","/home","/getPass","/changePassword","/update","/logout","/upload","/EmployeeController","/MetacubeParking","/employees.jsp","/home.jsp","/getPass.jsp","/changePassword.jsp","/ImageUpload.jsp","/login.jsp","/vehicleRegistration.jsp","/update.jsp","/signup"})
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest) request;
	       HttpServletResponse servletResponse = (HttpServletResponse) response;
	       HttpSession session = servletRequest.getSession(false);
	       if(session.getAttribute("empId") == null) {
	    	   servletResponse.sendRedirect("login.jsp");
	    	   }
	    	   	
	       if (session == null) {
	           servletResponse.sendRedirect("login.jsp");
	       } else {
	           chain.doFilter(request, response);
	       }
	}

	/**
	* @see Filter#init(FilterConfig)
	*/
	public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
	   
	}
	
	/**
	* @see Filter#destroy()
	*/
	public void destroy() {
	// TODO Auto-generated method stub
	}	
}
