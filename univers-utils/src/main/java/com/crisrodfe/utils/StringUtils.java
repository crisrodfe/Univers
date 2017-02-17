package com.crisrodfe.utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum StringUtils.
 */
public enum StringUtils 
{
	
	/** The menu student. */
	MENU_STUDENT("STUDENTS"),
	
	/** The menu university. */
	MENU_UNIVERSITY("UNIVERSITY"),
	
	/** The menu addstudent. */
	MENU_ADDSTUDENT("Add Student"),
	
	/** The menu removestudent. */
	MENU_REMOVESTUDENT("Remove Student"),
	
	/** The menu operations. */
	MENU_OPERATIONS("Operations")
	;
	
	/** The string. */
	private final String string;
	
	/**
	 * Instantiates a new string utils.
	 *
	 * @param string the string
	 */
	private StringUtils(String string)
	{
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
