package com.crisrodfe.repository.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crisrodfe.module.entity.Student;


// TODO: Auto-generated Javadoc
/**
 * The Interface StudentRepository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	/**
	 * Gets all the students.
	 *
	 * @return all the students
	 */
	@Query("select s from Student s order by s.firstName")
	List<Student> getAllStudents();
}
