package com.crisrodfe.services.student;

import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;

/**
 * The Interface AddStudentService.
 */
@Service
public interface AddStudentService {
	
	/**
	 * Save student.
	 *
	 * @param studentDAO the student DAO
	 */
	public void saveStudent(Student studentDAO);
}
