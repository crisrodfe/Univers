package com.crisrodfe.ui.commons;

import org.springframework.security.core.context.SecurityContextHolder;

import com.crisrodfe.navigator.UniversNavigator;
import com.crisrodfe.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * Builder pattern design.
 * 
 * @author CrisRodFe
 *
 */
@org.springframework.stereotype.Component
public class UniversMenuFactory implements UIComponentBuilder {
	
	/**
	 * The Class UniverseMenu.
	 */
	private class UniverseMenu extends VerticalLayout implements Property.ValueChangeListener {
		
		/** The main menu. */
		// Tipo de componente.Menú desplegable.
		private Tree mainMenu;

		/**
		 * Inits the component.
		 *
		 * @return the universe menu
		 */
		public UniverseMenu init() {
			mainMenu = new Tree();
			mainMenu.addValueChangeListener(this);	
			return this;
		}


		/**
		 * Layout configuration.
		 * It adds de layout to the UI
		 *
		 * @return the universe menu
		 */
		public UniverseMenu layout() {
			setWidth("100%");
			setHeightUndefined();

			mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
			mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());

			mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());
			mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());
			
			mainMenu.addItem(StringUtils.MENU_ADDSTUDENT.getString());
			mainMenu.addItem(StringUtils.MENU_REMOVESTUDENT.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADDSTUDENT.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVESTUDENT.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADDSTUDENT.getString(), StringUtils.MENU_STUDENT.getString());
			mainMenu.setParent(StringUtils.MENU_REMOVESTUDENT.getString(), StringUtils.MENU_STUDENT.getString());

			mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(), false);
			mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());

			mainMenu.addItem("LOGOUT");
			mainMenu.expandItem("LOGOUT");
			mainMenu.addItem("Logout");
			mainMenu.setChildrenAllowed("Logout", false);
			mainMenu.setParent("Logout","LOGOUT");
			
			
			addComponent(mainMenu);

			return this;
		}

		/* (non-Javadoc)
		 * @see com.vaadin.data.Property.ValueChangeListener#valueChange(com.vaadin.data.Property.ValueChangeEvent)
		 */
		public void valueChange(ValueChangeEvent event) {
			String selectedItemPath = (String) event.getProperty().getValue();
			if (selectedItemPath == null) return;
			if( selectedItemPath.equals("Logout")) {
				SecurityContextHolder.clearContext();
				UI.getCurrent().getPage().setLocation("/univers-web/login");
			}
			String path = selectedItemPath.toLowerCase().replaceAll("\\s+","");
			UniversNavigator.navigate(path);
		}
	}

	/**
	 *
	 * @return the component
	 */
	public Component createComponent() {
		return new UniverseMenu().init().layout();
	}

}
