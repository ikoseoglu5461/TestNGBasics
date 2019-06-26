package com.class02;

import org.testng.annotations.Test;

public class priorty {

	
	@Test (priority=1)
	public void first() {
		System.out.println("first test annotation");
	}
	
	@Test
	public void second() {
		System.out.println("second test annotation");
	}
	
	@Test
	public void third() {
		System.out.println("third test annotation");
	}
	
	@Test
	public void fourth() {
		System.out.println("fourth test annotation");
	}
	
	
}