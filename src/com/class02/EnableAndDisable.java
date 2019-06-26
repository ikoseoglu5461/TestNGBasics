package com.class02;

import org.testng.annotations.Test;

public class EnableAndDisable {
	
	@Test (enabled=false)
	public void first() {
		System.out.println("first test annotation");
	}
	
	@Test
	public void second() {
		System.out.println("second test annotation");
	}
	
	@Test (enabled=false)
	public void third() {
		System.out.println("third test annotation");
	}
	
	@Test (enabled=true)
	public void fourth() {
		System.out.println("fourth test annotation");
	}
	
	
}

