package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
					
				default:
					System.out.println(command);
				}
			}
			
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void showAccount(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		//System.out.println(userId);
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserAccount.jsp");
		dispatcher.forward(request, response);
	}


}
