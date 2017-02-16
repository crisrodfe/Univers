package com.crisrodfe.services.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class RemoveStudentServiceImpl implements RemoveStudentService{

	@Autowired
	private StudentRepository repository;
	
	@Transactional
	public void removeStudent(Student student) {
		repository.delete(student);
	}
}
