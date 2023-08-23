package com.example.demo.customException;

public class DataException extends Exception{

	static final  long serialVersionUID = 1938309077403498406L;
	
	public DataException(String message) {
		super(message);
	}
}
