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

/**
 * A factory for creating StatisticsLayout objects.
 */
@Component
public class StatisticsLayoutFactory implements UIComponentBuilder{

	/** The universities. */
	private List<University> universities;
	
	/** The statistics layout. */
	private StatisticsUniversityLayout statisticsLayout;
	
	
	/** The show all universities service. */
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	/** The university statistics service. */
	@Autowired
	private UniversityStatisticsService universityStatisticsService;
	
	/**
	 * The Class StatisticsUniversityLayout.
	 */
	private class StatisticsUniversityLayout extends VerticalLayout {
			
		/**
		 * Load.
		 *
		 * @return the statistics university layout
		 */
		public StatisticsUniversityLayout load() {
			universities = showAllUniversitiesService.getAllUniversities();		
			return this;	
		}
		
		/**
		 * Layout.
		 *
		 * @return the statistics university layout
		 */
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
	
	/**
	 * Refresh.
	 */
	public void refresh() {
		if(statisticsLayout == null) return;
		statisticsLayout.removeAllComponents();
		statisticsLayout.load();
		statisticsLayout.layout();
	}
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.ui.commons.UIComponentBuilder#createComponent()
	 */
	public com.vaadin.ui.Component createComponent() {
		
		statisticsLayout = new StatisticsUniversityLayout();
		return statisticsLayout.load().layout();
	}
	
}
