package com.class03;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsExample {

	@BeforeGroups({"Smoke", "Regression"})
	public void beforeGroup() {
		System.out.println("Before Group");
	}
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
	@AfterGroups
	public void afterGroup() {
		System.out.println("After Group");
	}
	
}
