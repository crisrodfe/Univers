package com.crisrodfe.services.university;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.repository.university.UniversityRepository;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class AddUniversityServiceImpl implements AddUniversityService {

	@Autowired
	private UniversityRepository universityRepository;
	
	@Transactional
	public void addUniversity(University universityDAO) {
		University university = new University();
		university.setUniversityName(universityDAO.getUniversityName());
		university.setUniversityCountry(universityDAO.getUniversityCountry());
		university.setUniversityCity(universityDAO.getUniversityCity());
		
		universityRepository.save(university);
		
	}

}
