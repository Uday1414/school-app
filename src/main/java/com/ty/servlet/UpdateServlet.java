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

@WebServlet(value = "/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		long phone = Long.parseLong(req.getParameter("phone") ) ;
		
		StudentDto dto = new StudentDto() ;
		dto.setId(id);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		StudentService service = new StudentService() ;
		StudentDto updated = service.updateStudent(dto) ;
		
		if(updated != null) {
			RequestDispatcher dispatcher  = req.getRequestDispatcher("view") ;
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher  = req.getRequestDispatcher("createstudent.jsp") ;
			dispatcher.forward(req, resp);
		}
		
		
	}
}
