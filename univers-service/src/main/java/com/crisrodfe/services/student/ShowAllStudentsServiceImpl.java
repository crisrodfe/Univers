package com.crisrodfe.services.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

/**
 * The Class ShowAllStudentsServiceImpl.
 */
@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class ShowAllStudentsServiceImpl implements ShowAllStudentsService
{
	
	/** The repository. */
	@Autowired
	private StudentRepository repository;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.student.ShowAllStudentsService#getAllStudents()
	 */
	public List<Student> getAllStudents() {
		
		return repository.getAllStudents();
	}

}
