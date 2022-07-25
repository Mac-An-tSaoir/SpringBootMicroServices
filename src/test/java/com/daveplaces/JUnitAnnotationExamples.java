package com.daveplaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class JUnitAnnotationExamples {
	
	@Test
	public void runTests() {
		int i = 2 + 4;
		assertEquals(3, i);
	}

}
