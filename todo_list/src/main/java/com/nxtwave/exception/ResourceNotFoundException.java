package com.nxtwave.exception;

public class ResourceNotFoundException extends RuntimeException{

	String resaurceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resaurceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s: %s", resaurceName, fieldName, fieldValue));
		this.resaurceName = resaurceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
