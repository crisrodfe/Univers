package com.crisrodfe.services.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.repository.university.UniversityRepository;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class ShowAllUniversitiesServiceImpl implements ShowAllUniversitiesService{

	@Autowired
	private UniversityRepository universityRepository;
	
	public List<University> getAllUniversities() {
		return universityRepository.getAllUniversities();
	}

	
}
