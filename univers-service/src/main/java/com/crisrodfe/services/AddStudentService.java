package com.crisrodfe.services;

import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;

@Service
public interface AddStudentService {
	
	public void saveStudent(Student studentDAO);
}
