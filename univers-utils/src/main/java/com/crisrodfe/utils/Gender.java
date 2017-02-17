package com.crisrodfe.utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum Gender.
 */
public enum Gender {
	
	/** The male. */
	MALE("Male"),
	
	/** The female. */
	FEMALE("Female");
	
	/** The string. */
	private String string;
	
	/**
	 * Instantiates a new gender.
	 *
	 * @param string the string
	 */
	private Gender(String string){
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
