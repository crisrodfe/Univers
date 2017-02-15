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

@SpringView(name=UniversityLayoutFactory.NAME, ui=UniversMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View, UniversitySavedListener{

	public static final String NAME = "operations";

	private TabSheet tabSheet;
	
	@Autowired
	private AddUniversityLayoutFactory addUniversityLayoutFactory;
	
	@Autowired 
	private ShowUniversitiesLayoutFactory showUniversitiesLayoutFactory;
	
	@Autowired
	private StatisticsLayoutFactory statisticsLayoutFactory;
	
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

	public void universitySaved() {
		showUniversitiesLayoutFactory.refreshTable();
		statisticsLayoutFactory.refresh();
	}
	
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

}
