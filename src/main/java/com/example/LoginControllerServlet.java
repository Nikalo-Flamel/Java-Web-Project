package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static RUserDBUtil RUserDBUtil = new RUserDBUtil();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		eraseCookie(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			RegisteredUser user = RUserDBUtil.getUserbyUserName(userName);
			
			boolean isSuccess = RUserDBUtil.validateUser(user, password);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if (isSuccess == true) {
				Cookie cookie1 = new Cookie("user", "RegisteredUser");
				cookie1.setMaxAge(60*60*24*365);
				response.addCookie(cookie1);
				
				Cookie cookie2 = new Cookie("userId", ("" + user.getId()));
				cookie2.setMaxAge(60*60*24*365);
				response.addCookie(cookie2);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?UserId=" + user.getId());
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserlogin.jsp?logged=false");
				dispatcher.forward(request, response);
			}
		}
		catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
	}

}
