package com.crisrodfe.ui.commons;


import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

/**
 * Build Pattern design.
 *
 * @author CrisRodFe
 */
@org.springframework.stereotype.Component
public class UniversLogoLayoutFactory implements UIComponentBuilder
{

	/**
	 * The Class LogoLayout.
	 */
	private class LogoLayout extends VerticalLayout 
	{	
		
		/** The logo. */
		private Embedded logo;
		
		/**
		 * @return LogoLayout
		 */
		public LogoLayout init() 
		{
			logo = new Embedded();

			return this;
		}
		
		/**
		 * Layout configuration.
		 *
		 * @return the logo layout
		 */
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
	 * @return the component
	 */
	public Component createComponent()
	{
		return new LogoLayout().init().layout();
	}

}
