package com.crisrodfe.services.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;

/**
 * The Interface ShowAllStudentsService.
 */
@Service
public interface ShowAllStudentsService {
	
	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	public List<Student> getAllStudents();
}
