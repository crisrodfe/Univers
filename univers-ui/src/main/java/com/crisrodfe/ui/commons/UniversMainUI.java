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

@SpringUI(path = UniversMainUI.NAME)
@Title("U n i v e r s")
@Theme("valo") // El layout lo gestiona vaadin, no usaremos css.
public class UniversMainUI extends UI {
	// Path de la vista.
	public static final String NAME = "/ui";

	private Panel changeTab = new Panel();

	/*
	 * Toda clase con las anotaciones de spring de componente, servicio,etc será
	 * incluida en el contexto.
	 */
	@Autowired
	private ApplicationContext appContext;

	// Clases que crearán nuestros componentes de la vista.
	@Autowired
	private UniversLogoLayoutFactory universLogoLayoutFactory;
	@Autowired
	private UniversMenuFactory universMenuFactory;

	// El SpringProvider buscará todas las clases con la anotación @SpringView y
	// las inyectará al proyecto.
	@Autowired
	private SpringViewProvider viewProvider;

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

	private void initNavigator() {
		// Instanciamos el navigator.Indicamos cual es la ui y el panel donde se
		// hara el cambio de vista.
		UniversNavigator navigator = new UniversNavigator(this, changeTab);

		// Inyectamos nuestro navegador de pestañas en el contexto de la aplicación
		// Es la forma manual de hacer la inyección de dependencias que realiza Spring automáticamente con las anotaciones.
		appContext.getAutowireCapableBeanFactory().autowireBean(navigator);
		navigator.addProvider(viewProvider);
		navigator.navigateTo(StudentLayoutFactory.NAME);
	}

}
