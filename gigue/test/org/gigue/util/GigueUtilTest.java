package org.gigue.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.gigue.exceptions.GigueException;
import org.junit.Test;


public class GigueUtilTest {

	@Test
	public void itShouldAcceptPairsOfArgumentsAndConvertThemToAMap() {
		Map<String, Object> map = GigueUtil.map("a", 1);
		assertTrue(map.containsKey("a"));
		assertEquals(1, map.get("a"));
	}
	
	@Test
	public void itShouldRequireArguments() {
		try {
			GigueUtil.map();
			fail();
		} catch (GigueException e) {
			assertEquals(GigueUtil.ARGUMENTS_REQUIRED, e.getMessage());
		}
	}
	
	@Test
	public void itShouldRequireArgumentPairs() {
		try {
			GigueUtil.map("a", 1, "b");
			fail();
		} catch (GigueException e) {
			assertEquals(GigueUtil.ARGUMENT_PAIRS_REQUIRED, e.getMessage());
		}
	}
}
