package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.StudentDto;
import com.ty.service.StudentService;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =  Integer.parseInt(req.getParameter("id")) ;
		
		StudentService service = new StudentService() ;
		StudentDto dto = service.getStudentById(id) ;
		if(dto != null) {
		req.setAttribute("student", dto);
		RequestDispatcher dispatcher =  req.getRequestDispatcher("update.jsp") ;
		dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher =  req.getRequestDispatcher("createstudent.jsp") ;
			dispatcher.forward(req, resp);
		}
		
	}
	
}
