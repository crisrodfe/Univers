package com.crisrodfe.ui.commons;


import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

/**
 * Diseño Build Patterm
 * @author CrisRodFe
 */
@org.springframework.stereotype.Component
public class UniversLogoLayoutFactory implements UIComponentBuilder
{

	private class LogoLayout extends VerticalLayout 
	{	
		//Instancia del componente.
		private Embedded logo;
		
		/**
		 * Devuelve una instancia del objeto/componente ya configurado.
		 * @return LogoLayout
		 */
		public LogoLayout init() 
		{
			logo = new Embedded();

			return this;
		}
		
		//Añade el componente y lo sitúa.
		public LogoLayout layout()
		{
			logo.setSource(new ThemeResource("../../images/universe_2.png"));
			logo.setWidth("398px");
			logo.setHeight("241px");
			addComponent(logo);
			setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
			return this;
		}
	}
	
	/**
	 * Devuelve el componente Tree.
	 * Al crear la nueva instancia se llama al init y al método que lo configurará-
	 */
	public Component createComponent()
	{
		return new LogoLayout().init().layout();
	}

}
