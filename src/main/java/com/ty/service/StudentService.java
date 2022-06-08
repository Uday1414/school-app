package com.ty.service;

import java.util.List;

import com.ty.dao.StudentDao;
import com.ty.dto.StudentDto;

public class StudentService {

	StudentDao studentDao = new StudentDao() ;
	
	public StudentDto saveStudent(StudentDto studentDto) {
		return  studentDao.saveStudent(studentDto) ;
	}
	
	public StudentDto updateStudent(StudentDto studentDto) {
		return  studentDao.updateStudent(studentDto) ;
	}
	
	public List<StudentDto> getStudents(){
		return studentDao.getStudents() ;
	}
	
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
	
	public StudentDto getStudentById(int id) {
		return studentDao.getStudentById(id) ;
	}
}
