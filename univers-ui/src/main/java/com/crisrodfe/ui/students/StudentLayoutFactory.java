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

/**
 * A factory for creating StudentLayout objects.
 */
@SpringView(name=StudentLayoutFactory.NAME, ui=UniversMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View,StudentSavedListener {

	/** The Constant NAME. */
	public static final String NAME = "addstudent";

	/** The add student layout factory. */
	@Autowired
	private AddStudentLayoutFactory addStudentLayoutFactory;
	
	/** The show all students layuot factory. */
	@Autowired
	private ShowAllStudentsLayoutFactory showAllStudentsLayuotFactory;
	
	/** The tab sheet. */
	private TabSheet tabSheet;
	
	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		addLayout();
	}

	/**
	 * Adds the layout.
	 */
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

	/* (non-Javadoc)
	 * @see com.crisrodfe.ui.students.StudentSavedListener#studentSaved()
	 */
	public void studentSaved() {
		showAllStudentsLayuotFactory.refreshTable();	
	}
}
