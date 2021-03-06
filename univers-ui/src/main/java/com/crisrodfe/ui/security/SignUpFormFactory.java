package com.crisrodfe.ui.security;

import org.jboss.jandex.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.services.security.RegisterUserService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;

/**
 * A factory for creating SignUpForm objects.
 */
@org.springframework.stereotype.Component
public class SignUpFormFactory {

	/** The register user service. */
	@Autowired
	private RegisterUserService registerUserService;
	
	/**
	 * The Class SignUpForm.
	 */
	private class SignUpForm {
		
		/** The root. */
		private VerticalLayout root;
		
		/** The panel. */
		private Panel panel;
		
		/** The username. */
		private TextField username;
		
		/** The password field. */
		private PasswordField passwordField;
		
		/** The password again field. */
		private PasswordField passwordAgainField;
		
		/** The save button. */
		private Button saveButton;
	
		/**
		 * Inits the UI.
		 *
		 * @return the sign up form
		 */
		public SignUpForm init() {
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			
			panel = new Panel("SignUp");
			panel.setSizeUndefined();
			
			saveButton = new Button("Save");
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			
			username = new TextField("Username");
			passwordField = new PasswordField("Password");
			passwordAgainField = new PasswordField("Password");
			
			saveButton.addClickListener(new ClickListener() {
				
				public void buttonClick(ClickEvent event) {
					if(!passwordAgainField.getValue().equals(passwordField.getValue())){					
						Notification.show("Passwords don`t match",com.vaadin.ui.Notification.Type.ERROR_MESSAGE);
						return;
					}
						
					registerUserService.save(username.getValue(), passwordField.getValue());
					UI.getCurrent().getPage().setLocation("/univers-web/login");
				}
			});
			
			return this;
			
		}
		
		/**
		 * Layout.
		 *
		 * @return the component
		 */
		public Component layout() {
			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
			
			FormLayout signUpLayout = new FormLayout();
			signUpLayout.addComponent(username);
			signUpLayout.addComponent(passwordField);
			signUpLayout.addComponent(passwordAgainField);
			
			signUpLayout.addComponent(new HorizontalLayout(saveButton));
			signUpLayout.setSizeUndefined();
			signUpLayout.setMargin(true);
			
			panel.setContent(signUpLayout);
			
			return root;
		}
	}
	
	/**
	 * Creates a new SignUpForm object.
	 *
	 * @return the component
	 */
	public Component createComponent() {
		return new SignUpForm().init().layout();
	}
}
