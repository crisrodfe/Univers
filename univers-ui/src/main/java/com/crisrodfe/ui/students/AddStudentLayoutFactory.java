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

@org.springframework.stereotype.Component
public class AddStudentLayoutFactory {

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
		private TextField lastName;
		private TextField age;
		private ComboBox gender;
		private ComboBox university;
		private Button saveButton;
		private Button clearButton;

		// Para realizar el binding entre objetos Student y partes de la UI.
		private BeanFieldGroup<Student> fieldGroup;
		private Student student;
		
		private StudentSavedListener studentSavedListener;
		
		public AddStudentMainLayout(StudentSavedListener studentSavedListener)
		{
			this.studentSavedListener = studentSavedListener;
		}

		/**
		 * Inicializa los componentes UI.
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
		 */
		public AddStudentMainLayout bind() {
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(student);
			return this;
		}

		/**
		 * Configura el Layout y coloca los componentes en él.
		 * 
		 * @return
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

		public void buttonClick(ClickEvent event) {
			if(event.getSource() == this.saveButton){
				save();
			} else {
				clearFields();
			}
			
		}

		private void clearFields() {
			firstName.setValue(null);
			lastName.setValue(null);
			gender.setValue(null);
			age.setValue(null);
			university.setValue(null);
			
		}

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

		private boolean isSavedOperationValid() {
			
			return showAllUniversities.getAllUniversities().size() != 0;
		}
		
		public AddStudentMainLayout load() {
			university.addItems(showAllUniversities.getAllUniversities());			
			return this;
		}
	}

	@Autowired
	private ShowAllUniversitiesService showAllUniversities;
	
	@Autowired
	private AddStudentService addStudentService;
	
	public Component createComponent(StudentSavedListener studentSavedListener) {
		return new AddStudentMainLayout(studentSavedListener).init().load().bind().layout();
	}
}
