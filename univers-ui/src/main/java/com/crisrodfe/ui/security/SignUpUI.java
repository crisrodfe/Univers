package com.crisrodfe.ui.security;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path=SignUpUI.PATH)
@Theme("valo")
public class SignUpUI extends UI{
	public static final String PATH = "/signup";
	
	@Autowired
	private SignUpFormFactory signUpFormFactory;
	
	@Override
	protected void init(VaadinRequest request) {
		setContent(signUpFormFactory.createComponent());
	}
}
