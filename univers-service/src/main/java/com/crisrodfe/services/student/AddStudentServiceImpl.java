package com.crisrodfe.services.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.repository.student.StudentRepository;

/**
 * The Class AddStudentServiceImpl.
 */
@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class AddStudentServiceImpl implements AddStudentService{

	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.student.AddStudentService#saveStudent(com.crisrodfe.module.entity.Student)
	 * Antes de guardar los datos en la BD crea una nueva instancia Student a partir de los datos del objeto studentDAO
	 */
	@Transactional
	public void saveStudent(Student studentDAO) {
		Student student = new Student();
		student.setUniversity(studentDAO.getUniversity());
		student.setFirstName(studentDAO.getFirstName());
		student.setLastName(studentDAO.getLastName());
		student.setGender(studentDAO.getGender());
		student.setAge(studentDAO.getAge());
		
		studentRepository.save(student);
		
	}
}
