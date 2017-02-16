package com.crisrodfe.ui.students;

import java.util.List;

import javax.swing.ButtonModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.services.student.RemoveStudentService;
import com.crisrodfe.services.student.ShowAllStudentsService;
import com.crisrodfe.ui.commons.UniversMainUI;
import com.crisrodfe.utils.NotificationMessages;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name=RemoveStudentLayoutFactory.NAME,ui=UniversMainUI.class)
public class RemoveStudentLayoutFactory extends VerticalLayout implements View, Button.ClickListener{

	public static final String NAME = "removestudent";
	
	private Grid removeStudentTable;
	private Button removeStudentButton;
	private List<Student> students;
	
	@Autowired
	private ShowAllStudentsService allStudentsService;
	
	@Autowired
	private RemoveStudentService removeStudentService;
	
	private void addLayout(){
		removeStudentButton = new Button("Remove");
		setMargin(true);
		
		BeanItemContainer<Student> container = new BeanItemContainer<Student>(Student.class,students);
		
		removeStudentTable = new Grid(container);
		removeStudentTable.setColumnOrder("firstName","lastName","gender","age");
		removeStudentTable.removeColumn("id");
		removeStudentTable.removeColumn("university");
		removeStudentTable.setImmediate(true);
		removeStudentTable.setSelectionMode(SelectionMode.MULTI);
		
		removeStudentButton.addClickListener(this);
		removeStudentButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		
		addComponent(removeStudentTable);
		addComponent(removeStudentButton);
	}
	
	private void loadStudents() {
		students = allStudentsService.getAllStudents();
	}

	public void buttonClick(ClickEvent event) {
		MultiSelectionModel selectionModel = (MultiSelectionModel) removeStudentTable.getSelectionModel();
		
		for(Object selectedItem : selectionModel.getSelectedRows()) {
			Student student = (Student) selectedItem;
			removeStudentTable.getContainerDataSource().removeItem(student);
			removeStudentService.removeStudent(student);
		}
		Notification.show("Student(s) succesfully removed");
		removeStudentTable.getSelectionModel().reset();
	}
	
	public void enter(ViewChangeEvent event) {
		if(removeStudentTable != null) return;
		loadStudents();
		addLayout();
	}
}
