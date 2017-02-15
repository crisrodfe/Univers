package com.crisrodfe.ui.commons;

import com.crisrodfe.navigator.UniversNavigator;
import com.crisrodfe.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

/**
 * Diseño Builder pattern.
 * 
 * @author CrisRodFe
 *
 */
@org.springframework.stereotype.Component
public class UniversMenuFactory implements UIComponentBuilder {
	
	private class UniverseMenu extends VerticalLayout implements Property.ValueChangeListener {
		
		// Tipo de componente.Menú desplegable.
		private Tree mainMenu;

		// Instanciación del componente.
		public UniverseMenu init() {
			mainMenu = new Tree();
			mainMenu.addValueChangeListener(this);	
			return this;
		}

		// Configuración: tamaño, texto,jerarquía.
		// También se añade el componente a UniverseMenu (que es en esencia un VerticalLayout)
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

			addComponent(mainMenu);

			return this;
		}

		public void valueChange(ValueChangeEvent event) {
			String selectedItemPath = (String) event.getProperty().getValue();
			if (selectedItemPath == null) return;
			
			String path = selectedItemPath.toLowerCase().replaceAll("\\s+","");
			UniversNavigator.navigate(path);
		}
	}

	/**
	 * Devuelve el componente Tree. Al crear la nueva instancia se llama al init
	 * y al método que lo configurará-
	 */
	public Component createComponent() {
		return new UniverseMenu().init().layout();
	}

}
