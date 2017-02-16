package com.crisrodfe.services.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.repository.university.UniversityRepository;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class UniversityStatisticsServiceImpl implements UniversityStatisticsService {

	@Autowired
	private UniversityRepository universityRepository;
	
	public Integer getNumOfStudentsForUniversity(Integer universityId) {
		
		return universityRepository.getNumOfStudentsForUniversity(universityId);
	}

}
