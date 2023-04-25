package com.telusko.Demojunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestCalculator{

	Calculator c = null;
	
	@Before
	public void setUp()
	{
		c = new Calculator();
	}
	
	@Test
	public void testAdd() {
		assertEquals(10,c.add(2,3));
	}
}
