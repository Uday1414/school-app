package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.StudentDto;
import com.ty.service.StudentService;

@WebServlet(value = "/view")
public class ViewStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService service = new StudentService();
		List<StudentDto> students = service.getStudents();
		req.setAttribute("studentslist", students);
		RequestDispatcher dispatcher =  req.getRequestDispatcher("viewstudent.jsp") ;
		dispatcher.forward(req, resp);
	}
}
