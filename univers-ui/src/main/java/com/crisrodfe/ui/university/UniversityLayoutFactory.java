package com.crisrodfe.ui.university;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.ui.commons.UniversMainUI;
import com.crisrodfe.ui.statistics.StatisticsLayoutFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;


/**
 * A factory for creating UniversityLayout objects.
 */
@SpringView(name=UniversityLayoutFactory.NAME, ui=UniversMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View, UniversitySavedListener{

	/** The Constant NAME. */
	public static final String NAME = "operations";

	/** The tab sheet. */
	private TabSheet tabSheet;
	
	/** The add university layout factory. */
	@Autowired
	private AddUniversityLayoutFactory addUniversityLayoutFactory;
	
	/** The show universities layout factory. */
	@Autowired 
	private ShowUniversitiesLayoutFactory showUniversitiesLayoutFactory;
	
	/** The statistics layout factory. */
	@Autowired
	private StatisticsLayoutFactory statisticsLayoutFactory;
	
	/**
	 * Adds the layout.
	 */
	private void addLayout() {
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addUniversityTab = addUniversityLayoutFactory.createComponent(this);
		Component showAlluniversitiesTab = showUniversitiesLayoutFactory.createComponent();
		Component showStatistics = statisticsLayoutFactory.createComponent();
		
		tabSheet.addTab(addUniversityTab,"Add University");
		tabSheet.addTab(showAlluniversitiesTab,"Show all universities");
		tabSheet.addTab(showStatistics,"Statistics");
		
		addComponent(tabSheet);
	}

	/* (non-Javadoc)
	 * @see com.crisrodfe.ui.university.UniversitySavedListener#universitySaved()
	 */
	public void universitySaved() {
		showUniversitiesLayoutFactory.refreshTable();
		statisticsLayoutFactory.refresh();
	}
	
	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

}
