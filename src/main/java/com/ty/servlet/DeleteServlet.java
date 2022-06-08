package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.service.StudentService;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession() ;
		
		if(httpSession.getAttribute("email") != null) {
		int num = Integer.parseInt(req.getParameter("id")) ;
		
		StudentService service = new StudentService() ;
		boolean res = service.deleteStudentById(num);
		
		if(res) {
		RequestDispatcher dispatcher  = req.getRequestDispatcher("view") ;
		dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher  = req.getRequestDispatcher("createstudent.jsp") ;
			dispatcher.forward(req, resp);
		}
		}else {
			RequestDispatcher dispatcher  = req.getRequestDispatcher("login.jsp") ;
			dispatcher.forward(req, resp);
		}
	}
}
