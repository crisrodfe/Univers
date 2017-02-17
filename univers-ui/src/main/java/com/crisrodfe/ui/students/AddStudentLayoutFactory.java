package com.crisrodfe.ui.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.Student;
import com.crisrodfe.services.student.AddStudentService;
import com.crisrodfe.services.university.ShowAllUniversitiesService;
import com.crisrodfe.utils.Gender;
import com.crisrodfe.utils.NotificationMessages;
import com.crisrodfe.utils.StudentsString;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A factory for creating AddStudentLayout objects.
 */
@org.springframework.stereotype.Component
public class AddStudentLayoutFactory {

	/**
	 * The Class AddStudentMainLayout.
	 */
	private class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener{

		/**
		 * Componentes UI que utilizaremos en Data Binding. Tienen que tener el
		 * mismo nombre que las propiedades de la clase con la que haremos el
		 * binding.
		 * 
		 * En caso de que no queramos que tengan el mismo nombre podemos
		 * hacer: @PropertyId("firstName")//nombre de la propiedad de la clase
		 * private TextField firsNameDiferente;
		 */
		private TextField firstName;
		
		/** The last name. */
		private TextField lastName;
		
		/** The age. */
		private TextField age;
		
		/** The gender. */
		private ComboBox gender;
		
		/** The university. */
		private ComboBox university;
		
		/** The save button. */
		private Button saveButton;
		
		/** The clear button. */
		private Button clearButton;

		/** The field group. 
		 * Data binding between de ui and a Student object
		 * */
		private BeanFieldGroup<Student> fieldGroup;
		
		/** The student. */
		private Student student;
		
		/** The student saved listener. */
		private StudentSavedListener studentSavedListener;
		
		/**
		 * Instantiates a new adds the student main layout.
		 *
		 * @param studentSavedListener the student saved listener
		 */
		public AddStudentMainLayout(StudentSavedListener studentSavedListener)
		{
			this.studentSavedListener = studentSavedListener;
		}

		/**
		 * Inits the UI components and configures them..
		 * 
		 * @return AddStudentMainLayout
		 */
		public AddStudentMainLayout init() {
			fieldGroup = new BeanFieldGroup<Student>(Student.class);
			student = new Student();

			firstName = new TextField(StudentsString.FIRST_NAME.getString());
			lastName = new TextField(StudentsString.LAST_NAME.getString());
			age = new TextField(StudentsString.AGE.getString());
			
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			age.setNullRepresentation("");
			
			gender = new ComboBox(StudentsString.GENDER.getString());
			gender.addItem(Gender.MALE.getString());
			gender.addItem(Gender.FEMALE.getString());

			university = new ComboBox(StudentsString.UNIVERSITY.getString());
			university.setWidth("100%");
			
			saveButton = new Button(StudentsString.SAVE_BUTTON.getString());
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			saveButton.addClickListener(this);
			
			clearButton = new Button(StudentsString.CLEAR_BUTTON.getString());
			clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			clearButton.addClickListener(this);
			
			return this;
		}

		/**
		 * Configuramos al data-binding.
		 *
		 * @return the adds the student main layout
		 */
		public AddStudentMainLayout bind() {
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(student);
			return this;
		}

		/**
		 * Configura el Layout y coloca los componentes en él.
		 *
		 * @return the component
		 */
		public Component layout() {

			setMargin(true);

			GridLayout gridLayout = new GridLayout(2, 4);
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(firstName, 0, 0);
			gridLayout.addComponent(lastName, 1, 0);

			gridLayout.addComponent(age, 0, 1);
			gridLayout.addComponent(gender, 1, 1);

			gridLayout.addComponent(university,0,2,1,2);	
			
			gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);

			return gridLayout;
		}

		/* (non-Javadoc)
		 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
		 */
		public void buttonClick(ClickEvent event) {
			if(event.getSource() == this.saveButton){
				save();
			} else {
				clearFields();
			}
			
		}

		/**
		 * Clear fields.
		 */
		private void clearFields() {
			firstName.setValue(null);
			lastName.setValue(null);
			gender.setValue(null);
			age.setValue(null);
			university.setValue(null);
			
		}

		/**
		 * Save a new student with the data recieved from the UI.
		 */
		private void save() {
			
			if(!isSavedOperationValid()) {
				Notification.show("Error","There is no Universities on the database",Type.ERROR_MESSAGE);
				return;
			}
			
			try {
				//Coge el valor de los componentes de la UI y los mapea al objeto Student..
				fieldGroup.commit();
			} catch (CommitException e) {
				Notification.show(NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_TITLE.getString(),
						NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),Type.ERROR_MESSAGE);
				return;
			}
			
			addStudentService.saveStudent(student);
			studentSavedListener.studentSaved();
			Notification.show("Student Added");
			clearFields();
		}

		/**
		 * Checks if is saved operation valid.
		 *
		 * @return true, if is saved operation valid
		 */
		private boolean isSavedOperationValid() {
			
			return showAllUniversities.getAllUniversities().size() != 0;
		}
		
		/**
		 * Load.
		 *
		 * @return the adds the student main layout
		 */
		public AddStudentMainLayout load() {
			university.addItems(showAllUniversities.getAllUniversities());			
			return this;
		}
	}

	/** The show all universities. */
	@Autowired
	private ShowAllUniversitiesService showAllUniversities;
	
	/** The add student service. */
	@Autowired
	private AddStudentService addStudentService;
	
	/**
	 * Creates a new AddStudentLayout object.
	 *
	 * @param studentSavedListener the student saved listener
	 * @return the component
	 */
	public Component createComponent(StudentSavedListener studentSavedListener) {
		return new AddStudentMainLayout(studentSavedListener).init().load().bind().layout();
	}
}
