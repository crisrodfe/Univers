package com.crisrodfe.ui.students;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving studentSaved events.
 * The class that is interested in processing a studentSaved
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStudentSavedListener<code> method. When
 * the studentSaved event occurs, that object's appropriate
 * method is invoked.
 *
 * @see StudentSavedEvent
 */
public interface StudentSavedListener {
	
	/**
	 * Student saved.
	 */
	public void studentSaved();
}
