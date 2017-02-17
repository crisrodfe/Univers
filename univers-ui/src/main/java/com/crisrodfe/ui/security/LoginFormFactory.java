package com.crisrodfe.ui.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

import ch.qos.logback.core.subst.Token.Type;

/**
 * A factory for creating LoginForm objects.
 */
@Component
public class LoginFormFactory {

	/** The dao authentication provider. */
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;
	
	/**
	 * The Class LoginForm.
	 */
	private class LoginForm {
		
		/** The root. */
		private VerticalLayout root;
		
		/** The panel. */
		private Panel panel;
		
		/** The username field. */
		private TextField usernameField;
		
		/** The password field. */
		private PasswordField passwordField;
		
		/** The login button. */
		private Button loginButton;
		
		/** The sign up button. */
		private Button signUpButton;
		
		/**
		 * Inits the UI.
		 *
		 * @return the login form
		 */
		public LoginForm init() {
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			
			panel = new Panel("Login");
			panel.setSizeUndefined();
			
			loginButton = new Button("Login");
			loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			
			signUpButton = new Button("Sign Up");
			signUpButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			
			usernameField = new TextField("Username");
			passwordField = new PasswordField("Password");
			
			return this;			
		}
		
		/**
		 * Layout.
		 *
		 * @return the com.vaadin.ui. component
		 */
		public com.vaadin.ui.Component layout() {
			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
			FormLayout loginLayout = new FormLayout();
			loginLayout.addComponent(usernameField);
			loginLayout.addComponent(passwordField);
			loginLayout.addComponent(new HorizontalLayout(loginButton,signUpButton));
			loginLayout.setSizeUndefined();
			loginLayout.setMargin(true);
			
			loginButton.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					try {
						//We use Spring Security for authenticate the user.
						Authentication auth = new UsernamePasswordAuthenticationToken(usernameField.getValue(), passwordField.getValue());
						Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
						SecurityContextHolder.getContext().setAuthentication(authenticated);
						UI.getCurrent().getPage().setLocation("/univers-web/ui");
					} catch (AuthenticationException e) {
						Notification.show("Error","Login failed",com.vaadin.ui.Notification.Type.ERROR_MESSAGE);
					}
				}
			});
			
			signUpButton.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					UI.getCurrent().getPage().setLocation("/univers-web/signup");
				}
			});
			
			panel.setContent(loginLayout);
			
			return root;
		}
		
	}
	
	/**
	 * Creates a new LoginForm object.
	 *
	 * @return the component
	 */
	public com.vaadin.ui.Component createComponent() {
		return new LoginForm().init().layout();
	}
}
