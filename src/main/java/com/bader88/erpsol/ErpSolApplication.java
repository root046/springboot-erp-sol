package com.bader88.erpsol;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErpSolApplication {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		SpringApplication.run(ErpSolApplication.class, args);
//		
//		Test test = new Test();
//		test.TestMethod();

//		TestAnnotation testAnnotation = new TestAnnotation();
//		Method method = testAnnotation.getClass().getMethod("testMethod");
//		MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//		System.out.println("Value is : " + annotation.log());

	}
	

}
