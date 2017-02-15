package com.crisrodfe.services.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService{

	@Autowired
	private StudentRepository repository;
	
	public void removeStudent(Student student) {
		repository.delete(student);
	}
}
