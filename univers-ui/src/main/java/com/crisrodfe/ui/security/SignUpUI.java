package com.crisrodfe.ui.security;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * The Class SignUpUI.
 */
@SpringUI(path=SignUpUI.PATH)
@Theme("valo")
public class SignUpUI extends UI{
	
	/** The Constant PATH.
	 *  The path with wich we well be able to enter this View/webpage
	 *  */
	public static final String PATH = "/signup";
	
	/** The sign up form factory. */
	@Autowired
	private SignUpFormFactory signUpFormFactory;
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		setContent(signUpFormFactory.createComponent());
	}
}
