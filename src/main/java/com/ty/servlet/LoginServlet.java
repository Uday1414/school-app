package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		
		if(email.equals("admin@mail") && password.equals("admin")) {
			
			HttpSession httpSession =  req.getSession() ;
			httpSession.setAttribute("email", email);
			
			RequestDispatcher dispatcher =  req.getRequestDispatcher("navbar.jsp") ;
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter = resp.getWriter() ;
			printWriter.write("<html><body> <h1> Login Failed</h1></body></html>");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp") ;
			dispatcher.include(req, resp);
		}
		
		
	}
}
