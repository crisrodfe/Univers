package com.crisrodfe.services.statistics;

/**
 * The Interface UniversityStatisticsService.
 */
public interface UniversityStatisticsService {
	
	/**
	 * Gets the num of students for university.
	 *
	 * @param universityId the university id
	 * @return the num of students for university
	 */
	public Integer getNumOfStudentsForUniversity(Integer universityId);
}
