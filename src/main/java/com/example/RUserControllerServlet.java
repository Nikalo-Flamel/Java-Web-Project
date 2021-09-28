package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RUserControllerServlet")
public class RUserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static RUserDBUtil RUserDBUtil = new RUserDBUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String command = request.getParameter("command");
			
			//System.out.println(command);
			
			if(command != null) {
				switch(command) {
				case "ACCOUNT":
					showAccount(request, response);
					break;
				case "LOAD":
					accountDetails(request, response);
					break;
//				case "UPDATE":
//					updateAccount(request, response);
//					break;
				case "DELETE":
					deleteAccount(request, response);
					break;
					
				default:
					System.out.println(command);
				}
			}
			
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			String command = request.getParameter("command");
			
			if(command != null) {
				switch(command) {	
				case "UPDATE":
					updateAccount(request, response);
					break;		
				default:
					System.out.println(command);
				}
			}
			
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		boolean isSuccess = RUserDBUtil.deleteUser(user);
		
		eraseCookie(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		int userId = Integer.parseInt(request.getParameter("userId"));		
		//System.out.println(userId);
		
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		RegisteredUser user = new RegisteredUser(userName, name, password, email, mobile, userId);
		
		
		boolean isSuccess = RUserDBUtil.updateRegisteredUser(user);
		
		user = RUserDBUtil.getRegisteredUser("" + userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserAccount.jsp");
		dispatcher.forward(request, response);
		
	}

	private void accountDetails(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		//System.out.println(userId);
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AccountDetails.jsp");
		dispatcher.forward(request, response);
	}

	private void showAccount(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		System.out.println(userId);
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserAccount.jsp");
		dispatcher.forward(request, response);
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
