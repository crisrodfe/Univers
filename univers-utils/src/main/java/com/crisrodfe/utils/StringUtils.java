package com.crisrodfe.utils;

public enum StringUtils 
{
	MENU_STUDENT("STUDENTS"),
	MENU_UNIVERSITY("UNIVERSITY"),
	MENU_ADDSTUDENT("Add Student"),
	MENU_REMOVESTUDENT("Remove Student"),
	MENU_OPERATIONS("Operations")
	;
	
	private final String string;
	
	private StringUtils(String string)
	{
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
