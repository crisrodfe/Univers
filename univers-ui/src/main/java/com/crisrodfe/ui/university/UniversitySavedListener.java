package com.crisrodfe.ui.university;

/**
 * The listener interface for receiving universitySaved events.
 * The class that is interested in processing a universitySaved
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addUniversitySavedListener<code> method. When
 * the universitySaved event occurs, that object's appropriate
 * method is invoked.
 *
 * @see UniversitySavedEvent
 */
public interface UniversitySavedListener {
	
	/**
	 * University saved.
	 */
	public void universitySaved();
}
