package com.crisrodfe.utils;

public enum StudentsString 
{
	MAIN_MENU("Main Menu"),
	SHOW_ALL("Show All Students"),
	FIRST_NAME("First name"),
	LAST_NAME("Last name"),
	GENDER("Gender"),
	AGE("Age"),
	SAVE_BUTTON("Save"),
	CLEAR_BUTTON("Clear"), 
	UNIVERSITY("University"),
	;
	
	private final String string;
	
	private StudentsString(String string){
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
