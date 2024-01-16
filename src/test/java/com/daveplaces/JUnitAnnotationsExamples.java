package com.daveplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JUnitAnnotationsExamples {

	@BeforeAll
	public static void setUpEverything() {
		int i = 1 + 1;
	}
	
	@BeforeEach 
	public void setUpBeforeEachTest() {
		int i = 1 + 1;
	}
	
	@Test 
	public void runTests() {
		double du = 1.01 + 1.02;
		assertEquals(2.0, du, 0.031);
	}
	
	@Test 
	public void runMoreTests() {
		int i = 1 + 1;
		assertEquals(2, i);
		Object ob = null;
		assertNull(ob);
		assertTrue(i == 2);
	}
	
	@Disabled(value="New to JUnit5")/*JUnit4 was @Ignore*/
	@Test
	public void runFailTest() {
		fail();
	}
	
	@AfterEach
	public void tearDownEverything() {
		int i = 1 + 1;
	}
	
	@AfterAll 
	public static void tearDownBeforeEachTest() {
		int i = 1 + 1;
	}
}
