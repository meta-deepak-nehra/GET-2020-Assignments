package com.example.demo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateSession {

	public static boolean isSessionValid(HttpSession session, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}
}
