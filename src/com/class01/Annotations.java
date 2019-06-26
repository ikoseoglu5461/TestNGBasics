package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test
	public void testOne() {
		System.out.println("TestOne");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}
	@Test
	public void testTwo() {
		System.out.println("TestTwo");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("BeforeGroups");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	@AfterGroups
	public void afterGroups() {
		System.out.println("AfterGroups");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

}
