package com.springboot;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String string)
	{
		super(string);
	}
}
