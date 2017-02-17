package com.crisrodfe.ui.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import com.crisrodfe.navigator.UniversNavigator;
import com.crisrodfe.ui.students.StudentLayoutFactory;
import com.crisrodfe.ui.university.UniversityLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Class UniversMainUI.
 */
@SpringUI(path = UniversMainUI.NAME)
@Title("U n i v e r s")
@Theme("valo") // Vaadin will take care of the UI interface style. We will not use CSS
public class UniversMainUI extends UI {
	
	/** The Constant NAME.
	 * View's path
	 *  */
	public static final String NAME = "/ui";

	/** The change tab. */
	private Panel changeTab = new Panel();

	/** The app context.
	 * All the classes with Spring Annotations will be injected into this context
	 *  */
	@Autowired
	private ApplicationContext appContext;

	/** The univers logo layout factory. */
	@Autowired
	private UniversLogoLayoutFactory universLogoLayoutFactory;
	
	/** The univers menu factory. */
	@Autowired
	private UniversMenuFactory universMenuFactory;

	/** The view provider. 
	 * It will look through all the project for @SpringView Annotations and will inject them.
	 * */
	@Autowired
	private SpringViewProvider viewProvider;

	/* (non-Javadoc)
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {

		changeTab.setHeight("100%");

		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");

		Panel logoPanel = new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeightUndefined();
		
		HorizontalLayout uiLayout = new HorizontalLayout();
		uiLayout.setSizeFull();
		uiLayout.setMargin(true);

		Component menu = universMenuFactory.createComponent();
		Component logo = universLogoLayoutFactory.createComponent();

		uiLayout.addComponent(menu);
		uiLayout.addComponent(changeTab);
		
		uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
		uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		
		uiLayout.setExpandRatio(menu, 1);
		uiLayout.setExpandRatio(changeTab, 2);
		
		logoPanel.setContent(logo);
		contentPanel.setContent(uiLayout);

		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);

		initNavigator();

		setContent(rootLayout);
	}

	/**
	 * Inits the navigator.
	 */
	private void initNavigator() {
		/**
		 * Navigator instance.
		 * @param this, we indicate which is the UI 
		 * @param changeTab, where in the UI the change view will take place. 
		 */
		UniversNavigator navigator = new UniversNavigator(this, changeTab);

		appContext.getAutowireCapableBeanFactory().autowireBean(navigator);
		navigator.addProvider(viewProvider);
		navigator.navigateTo(StudentLayoutFactory.NAME);
	}

}
