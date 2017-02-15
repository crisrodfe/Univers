package com.crisrodfe.ui.students;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.ui.commons.UniversMainUI;
import com.crisrodfe.utils.StudentsString;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=StudentLayoutFactory.NAME, ui=UniversMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View,StudentSavedListener {

	public static final String NAME = "addstudent";

	@Autowired
	private AddStudentLayoutFactory addStudentLayoutFactory;
	
	@Autowired
	private ShowAllStudentsLayoutFactory showAllStudentsLayuotFactory;
	
	private TabSheet tabSheet;
	
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

	private void addLayout() {
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = addStudentLayoutFactory.createComponent(this);
		Component showStudentsTab = showAllStudentsLayuotFactory.createComponent();
		
		tabSheet.addTab(addStudentMainTab,StudentsString.MAIN_MENU.getString());
		tabSheet.addTab(showStudentsTab,StudentsString.SHOW_ALL.getString());
		
		addComponent(tabSheet);
	}

	public void studentSaved() {
		showAllStudentsLayuotFactory.refreshTable();	
	}
}
