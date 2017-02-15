package com.crisrodfe.utils;

public enum Gender {
	MALE("Male"),
	FEMALE("Female");
	
	private String string;
	
	private Gender(String string){
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
