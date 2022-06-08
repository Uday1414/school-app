package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.StudentDto;

public class StudentDao {

	EntityManagerFactory  entityManagerFactory =  Persistence.createEntityManagerFactory("vikas") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public StudentDto saveStudent(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit(); 
		return  studentDto ;
	}
	
	public StudentDto updateStudent(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.merge(studentDto);
		entityTransaction.commit(); 
		return  studentDto ;
	}
	
	public List<StudentDto> getStudents(){
		String sql = "SELECT s FROM StudentDto s" ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
	}
	
	public boolean deleteStudentById(int id) {
		StudentDto studentDto = entityManager.find(StudentDto.class, id) ;
		entityTransaction.begin();
		entityManager.remove(studentDto);
		entityTransaction.commit(); 
		return true ;
	}
	
	public StudentDto getStudentById(int id) {
		return entityManager.find(StudentDto.class, id) ;
	}
	
}
