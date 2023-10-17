package com.bader88.erpsol;

public class TestAnnotation {
	
	@MyAnnotation(log = "test field..")
	String text;
	
	@MyAnnotation(log = "TEST method...")
	public void testMethod() {

	}

}
