package com.crisrodfe.services.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

/**
 * The Class RemoveStudentServiceImpl.
 */
@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class RemoveStudentServiceImpl implements RemoveStudentService{

	/** The repository. */
	@Autowired
	private StudentRepository repository;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.student.RemoveStudentService#removeStudent(com.crisrodfe.module.entity.Student)
	 */
	@Transactional
	public void removeStudent(Student student) {
		repository.delete(student);
	}
}
