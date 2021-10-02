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
import javax.servlet.http.HttpSession;

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static RUserDBUtil RUserDBUtil = new RUserDBUtil();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();  
        session.invalidate(); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			RegisteredUser user = RUserDBUtil.getUserbyUserName(userName);
			if (user != null) {
				int id = user.getId();
			}
//			System.out.println(id + "");
//			System.out.println("after id");
			
			boolean isSuccess = RUserDBUtil.validateUser(user, password);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if (isSuccess == true) {
				HttpSession session=request.getSession();
				session.setAttribute("user","RegisteredUser");
				session.setAttribute("userId",user.getId());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?UserId=" + user.getId());
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserlogin.jsp?logged=incorrect");
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
