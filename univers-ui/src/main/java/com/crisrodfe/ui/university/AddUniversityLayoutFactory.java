package com.crisrodfe.ui.university;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.services.university.AddUniversityService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddUniversityLayoutFactory {
	private class AddUniversityLayout extends VerticalLayout implements Button.ClickListener {

		private TextField universityName;
		private TextField universityCountry;
		private TextField universityCity;
		private Button saveButton;

		private University university;
		private BeanFieldGroup<University> beanFieldGroup;

		@Autowired
		private AddUniversityService addUniversityService;
		
		
		private UniversitySavedListener savedListener;
		public AddUniversityLayout(UniversitySavedListener savedListener) {
			this.savedListener = savedListener;
		}
		
		public AddUniversityLayout init() {

			university = new University();
			
			universityName = new TextField("Name");
			universityCountry = new TextField("Country");
			universityCity = new TextField("City");

			saveButton = new Button("Save",this);
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

			universityName.setNullRepresentation("");
			universityCountry.setNullRepresentation("");
			universityCity.setNullRepresentation("");

			return this;
		}

		public AddUniversityLayout bind() {

			beanFieldGroup = new BeanFieldGroup<University>(University.class);
			beanFieldGroup.bindMemberFields(this);
			beanFieldGroup.setItemDataSource(university);

			return this;
		}

		public AddUniversityLayout layout() {
			setWidth("100%");

			GridLayout gridLayout = new GridLayout(1, 4);
			gridLayout.setHeightUndefined();
			gridLayout.setSpacing(true);

			gridLayout.addComponent(universityName, 0, 0);
			gridLayout.addComponent(universityCountry, 0, 1);
			gridLayout.addComponent(universityCity, 0, 2);
			gridLayout.addComponent(saveButton, 0, 3);

			return this;
		}

		public void buttonClick(ClickEvent event) {
			try {
				beanFieldGroup.commit();
			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Notification.show("Error","Fields must be filled", Type.ERROR_MESSAGE);
				return;
			}
			clearFields();
			addUniversityService.addUniversity(university);
			savedListener.universitySaved();
			Notification.show("Save","University saved",Type.WARNING_MESSAGE);
		}

		private void clearFields() {
			universityName.setValue(null);
			universityCountry.setValue(null);
			universityCity.setValue(null);		
		}

	}

	public Component createComponent(UniversitySavedListener savedListener) {
		return new AddUniversityLayout(savedListener).init().bind().layout();
	}
}
