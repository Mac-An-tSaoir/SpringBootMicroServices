package com.daveplaces;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class JUnitAnnotationsExamples {

	@BeforeClass
	public static void setUpEverything() {
		int i = 1 + 1;
	}
	
	@Before 
	public void setUpBeforeEachTest() {
		int i = 1 + 1;
	}
	
	@Test 
	public void runTests() {
		int i = 1 + 1;
		assertEquals(3, i);
	}
	
	@Test 
	public void runMoreTests() {
		int i = 1 + 1;
		assertEquals(2, i);
	}
	
	@After
	public static void tearDownEverything() {
		int i = 1 + 1;
	}
	
	@AfterClass 
	public void tearDownBeforeEachTest() {
		int i = 1 + 1;
	}
}
