package com.daveplaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

public class JUnitAnnotationExamples {
	
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
		double i = 2.02 + 4.01;
		assertEquals(6, i, 0.4);
	}
	
	@Test
	public void runMoreTests() {
		int i = 1 + 4;
		assertEquals(5, i);
		String s = null;
		assertNull(s);
		assertTrue(5 == 4 + 1);
	}
	
	@Disabled
	@Test
	public void runFailTest() {
		fail();
	}
	
	@AfterAll
	public static void tearDownEverything() {
		int i = 1 + 1;
	}
	
	@AfterEach
	public void tearDownAfterEachTest() {
		int i = 1 + 1;
	}

}
