package com.crisrodfe.navigator;


import com.google.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

/**
 * The Class UniversNavigator.
 */
public class UniversNavigator extends Navigator {
	
	/**
	 * Instantiates a new univers navigator.
	 *
	 * @param ui the ui
	 * @param container the container
	 */
	public UniversNavigator(UI ui, SingleComponentContainer container) {
		super(ui, container);
	}

	/**
	 * Gets the navigator.
	 *
	 * @return the navigator
	 */
	private static UniversNavigator getNavigator() {
		UI ui = UI.getCurrent();
		Navigator navigator = ui.getNavigator();

		return (UniversNavigator) navigator;
	}

	/**
	 * Navigate.
	 *
	 * @param path the path
	 */
	public static void navigate(String path) {
		try {
			UniversNavigator.getNavigator().navigateTo(path);
		} catch (Exception e) {
			return;
		}
	}

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.Navigator#navigateTo(java.lang.String)
	 */
	@Override
	public void navigateTo(String viewName) {
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
