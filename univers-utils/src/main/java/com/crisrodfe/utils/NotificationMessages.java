package com.crisrodfe.utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum NotificationMessages.
 */
public enum NotificationMessages 
{
	
	/** The student save validation error title. */
	STUDENT_SAVE_VALIDATION_ERROR_TITLE("Error"),
	
	/** The student save validation error description. */
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled")
	;
	
	/** The string. */
	private final String string;
	
	/**
	 * Instantiates a new notification messages.
	 *
	 * @param string the string
	 */
	private NotificationMessages(String string)
	{
		this.string = string;
	}
	
	/**
	 * Gets the string.
	 *
	 * @return the string
	 */
	public String getString()
	{
		return this.string;
	}
}
