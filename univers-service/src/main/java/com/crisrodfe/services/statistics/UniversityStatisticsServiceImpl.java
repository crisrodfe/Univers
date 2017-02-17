package com.crisrodfe.services.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.repository.university.UniversityRepository;


/**
 * The Class UniversityStatisticsServiceImpl.
 * Hace uso de nuestro repositorio UniversityRepository para recibir datos de la BD.
 */
@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class UniversityStatisticsServiceImpl implements UniversityStatisticsService {

	/** The university repository. */
	@Autowired
	private UniversityRepository universityRepository;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.services.statistics.UniversityStatisticsService#getNumOfStudentsForUniversity(java.lang.Integer)
	 */
	public Integer getNumOfStudentsForUniversity(Integer universityId) {
		
		return universityRepository.getNumOfStudentsForUniversity(universityId);
	}

}
