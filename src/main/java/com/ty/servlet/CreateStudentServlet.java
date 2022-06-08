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

import com.ty.dto.StudentDto;
import com.ty.service.StudentService;

@WebServlet(value = "/save")
public class CreateStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		Long phone = Long.parseLong(req.getParameter("phone")) ;
		
		StudentDto dto =  new StudentDto() ;
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		StudentService service = new StudentService() ;
		StudentDto saved = service.saveStudent(dto) ;
		
		HttpSession httpSession = req.getSession() ;
		
		if(saved != null && httpSession != null){
			RequestDispatcher dispatcher = req.getRequestDispatcher("view") ;
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter =  resp.getWriter() ;
			printWriter.write("<html><body> <h1> Something went wrong </h1> </body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("createstudent.jsp") ;
			dispatcher.include(req, resp);
		}
		
	}
}
