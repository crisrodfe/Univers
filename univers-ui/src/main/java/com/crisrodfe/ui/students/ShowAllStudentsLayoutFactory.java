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


/**
 * A factory for creating ShowAllStudentsLayout UI objects.
 */
@org.springframework.stereotype.Component
public class ShowAllStudentsLayoutFactory implements UIComponentBuilder
{

	/** The students. */
	private List<Student> students;
	
	/** The container.
	 *  Used for binding data to UI component/s
	 *  */
	private BeanItemContainer<Student> container;
	
	/**
	 * The Class ShowallStudentsLayout.
	 */
	private class ShowallStudentsLayout extends VerticalLayout {
		
		/** The students table. */
		private Grid studentsTable;
		
		/**
		 * Inits the component.
		 *
		 * @return the showall students layout
		 */
		public ShowallStudentsLayout init(){
			
			setMargin(true);
			
			container = new BeanItemContainer<Student>(Student.class,students);
			studentsTable = new Grid(container);
			studentsTable.setColumnOrder("firstName","lastName","age","gender");
			studentsTable.removeColumn("id");
			studentsTable.removeColumn("university");
			studentsTable.setImmediate(true);
			
			return this;
		}
		
		/**
		 * Load all the students data..
		 *
		 * @return the showall students layout
		 */
		public ShowallStudentsLayout load() {
			students = allStudentsService.getAllStudents();
			return this;
		}
		
		/**
		 * Layout.
		 * It adds the table with the info into the ui
		 *
		 * @return the showall students layout
		 */
		public ShowallStudentsLayout layout() {
			
			addComponent(studentsTable);
			
			return this;
		}
		
	}
	
	/** The all students service. */
	@Autowired
	private ShowAllStudentsService allStudentsService;
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.ui.commons.UIComponentBuilder#createComponent()
	 */
	public Component createComponent() {
		return new ShowallStudentsLayout().load().init().layout();
	}

	/**
	 * Refresh table.
	 */
	public void refreshTable() {
		students = allStudentsService.getAllStudents();
		container.removeAllItems();
		container.addAll(students);	
	}

}
