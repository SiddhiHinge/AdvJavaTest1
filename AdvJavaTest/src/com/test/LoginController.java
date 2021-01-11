package com.test;

import javax.servlet.*;
import javax.servlet.http.*;

import com.test.LoginBean.*;

public class LoginController extends HttpServlet {

	LoginRepository repository = new LoginRepository();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String requestAction = request.getParameter("requestAction");
		System.out.println("RequestAction : "+requestAction);
		
		if(requestAction.equalsIgnoreCase("login")) {
			System.out.println("In login controller now !");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
					
			TestLogin login = new TestLogin(username, password);
			System.out.println(login);

			boolean check = repository.validateLogin(login);

			if (check) {
				try {
					response.sendRedirect("result.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Login done !");
			} else {
				System.out.println("Login not done !");
				request.setAttribute("loginStatus", check);
				try {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
