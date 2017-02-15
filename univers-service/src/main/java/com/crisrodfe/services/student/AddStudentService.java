package com.crisrodfe.services.student;

import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;

@Service
public interface AddStudentService {
	
	public void saveStudent(Student studentDAO);
}
