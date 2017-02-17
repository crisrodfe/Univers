package com.crisrodfe.utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum StudentsString.
 */
public enum StudentsString 
{
	
	/** The main menu. */
	MAIN_MENU("Main Menu"),
	
	/** The show all. */
	SHOW_ALL("Show All Students"),
	
	/** The first name. */
	FIRST_NAME("First name"),
	
	/** The last name. */
	LAST_NAME("Last name"),
	
	/** The gender. */
	GENDER("Gender"),
	
	/** The age. */
	AGE("Age"),
	
	/** The save button. */
	SAVE_BUTTON("Save"),
	
	/** The clear button. */
	CLEAR_BUTTON("Clear"), 
	
	/** The university. */
	UNIVERSITY("University"),
	;
	
	/** The string. */
	private final String string;
	
	/**
	 * Instantiates a new students string.
	 *
	 * @param string the string
	 */
	private StudentsString(String string){
		this.string = string;
	}
	
	/**
	 * Gets the string.
	 *
	 * @return the string
	 */
	public String getString(){
		return this.string;
	}
}
