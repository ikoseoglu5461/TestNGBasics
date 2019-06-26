package com.class03;

import org.testng.annotations.Test;

public class MethodsExample {
	
	
	@Test (groups="Smoke")
	public void One() {
		System.out.println("Test One");
	}
	@Test (groups="Regression")
	public void Two() {
		System.out.println("Test Two");
	}
	@Test (groups="Smoke")
	public void Three() {
		System.out.println("Test Three");
	}
	@Test (groups="Regression")
	public void Four() {
		System.out.println("Test Four");
	}
}