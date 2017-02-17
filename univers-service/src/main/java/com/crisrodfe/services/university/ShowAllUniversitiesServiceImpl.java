package com.crisrodfe.services.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.repository.university.UniversityRepository;

/**
 * The Class ShowAllUniversitiesServiceImpl.
 */
@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class ShowAllUniversitiesServiceImpl implements ShowAllUniversitiesService{

	/** The university repository. */
	@Autowired
	private UniversityRepository universityRepository;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.university.ShowAllUniversitiesService#getAllUniversities()
	 */
	public List<University> getAllUniversities() {
		return universityRepository.getAllUniversities();
	}

	
}
