package com.crisrodfe.ui.security;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * The Class LoginUI.
 */
@SpringUI(path=LoginUI.PATH)
@Theme("valo")
public class LoginUI extends UI{
	
	/** The Constant PATH. */
	public static final String PATH = "/login";

	/** The login form factory. */
	@Autowired
	private LoginFormFactory loginFormFactory;
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		setContent(loginFormFactory.createComponent());
	}
	
	
}
