package com.crisrodfe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;

@Service
public interface ShowAllStudentsService {
	public List<Student> getAllStudents();
}
