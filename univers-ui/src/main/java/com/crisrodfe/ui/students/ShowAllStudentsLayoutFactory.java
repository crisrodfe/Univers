package com.crisrodfe.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.services.student.ShowAllStudentsService;
import com.crisrodfe.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder
{

	private List<Student> students;
	private BeanItemContainer<Student> container;
	
	private class ShowallStudentsLayout extends VerticalLayout {
		
		private Grid studentsTable;
		
		public ShowallStudentsLayout init(){
			
			setMargin(true);
			
			container = new BeanItemContainer<Student>(Student.class,students);
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName","lastName","age","gender");
			studentsTable.removeColumn("id");
			studentsTable.setImmediate(true);
			
			return this;
		}
		
		public ShowallStudentsLayout load() {
			students = allStudentsService.getAllStudents();
			return this;
		}
		
		public ShowallStudentsLayout layout() {
			
			addComponent(studentsTable);
			
			return this;
		}
		
	}
	
	@Autowired
	private ShowAllStudentsService allStudentsService;
	
	public Component createComponent() {
		return new ShowallStudentsLayout().load().init().layout();
	}

	public void refreshTable() {
		students = allStudentsService.getAllStudents();
		container.removeAllItems();
		container.addAll(students);	
	}

}
