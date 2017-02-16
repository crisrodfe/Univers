package com.crisrodfe.services.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class ShowAllStudentsServiceImpl implements ShowAllStudentsService
{
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getAllStudents() {
		
		return repository.getAllStudents();
	}

}
