package com.crisrodfe.repository.university;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crisrodfe.module.entity.University;

// TODO: Auto-generated Javadoc
/**
 * The Interface UniversityRepository.
 */
@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
	
	/**
	 * Gets the all universities.
	 *
	 * @return the all universities
	 */
	@Query("select u from University u order by u.universityName")
	List<University> getAllUniversities();
	
	/**
	 * Gets the num of students for university.
	 *
	 * @param universityId the university id
	 * @return the num of students for university
	 */
	@Query("select count(s) from Student s where s.university.id =:universityId")
	Integer getNumOfStudentsForUniversity(@Param("universityId") Integer universityId);
}
