package com.crisrodfe.ui.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.services.statistics.UniversityStatisticsService;
import com.crisrodfe.services.university.ShowAllUniversitiesService;
import com.crisrodfe.ui.commons.UIComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
public class StatisticsLayoutFactory implements UIComponentBuilder{

	private List<University> universities;
	private StatisticsUniversityLayout statisticsLayout;
	
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	@Autowired
	private UniversityStatisticsService universityStatisticsService;
	
	private class StatisticsUniversityLayout extends VerticalLayout {
			
		public StatisticsUniversityLayout load() {
			universities = showAllUniversitiesService.getAllUniversities();		
			return this;	
		}
		
		public StatisticsUniversityLayout layout() {
			setMargin(true);
			
			for(University university : universities) {
				int numOfStudents = universityStatisticsService.getNumOfStudentsForUniversity(university.getId());
				Label label = new Label("<p><b>"+university.getUniversityName()+"</b>"+ "  -  "+numOfStudents+" students(s)"+"<p>",ContentMode.HTML);
				addComponent(label);
			}
				
			return this;
		}
			
	}
	
	public void refresh() {
		if(statisticsLayout == null) return;
		statisticsLayout.removeAllComponents();
		statisticsLayout.load();
		statisticsLayout.layout();
	}
	
	public com.vaadin.ui.Component createComponent() {
		
		statisticsLayout = new StatisticsUniversityLayout();
		return statisticsLayout.load().layout();
	}
	
}
