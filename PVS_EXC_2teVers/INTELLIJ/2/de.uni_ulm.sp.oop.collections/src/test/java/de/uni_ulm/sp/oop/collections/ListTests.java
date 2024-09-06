package de.uni_ulm.sp.oop.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ListTests {
	
	@Test
	void coverageTests() {
		LList s = new LList();
		assertEquals(0, s.size());
		assertFalse(s.remove(0));
		assertEquals(Optional.empty(), s.get(0));
		s.add(12);
		assertEquals(1, s.size());
		assertEquals(Optional.empty(), s.get(1));
		assertEquals(Optional.of(12), s.get(0));
		s.add(14);
		s.add(42);
		assertEquals(3, s.size());
		assertEquals(Optional.empty(), s.get(3));
		assertEquals(Optional.of(42), s.get(2));
		assertEquals(Optional.of(14), s.get(1));
		assertEquals(Optional.of(12), s.get(0));
		assertFalse(s.remove(3));
		assertTrue(s.remove(1));
		assertEquals(2, s.size());
		assertEquals(Optional.empty(), s.get(2));
		assertEquals(Optional.of(42), s.get(1));
		assertEquals(Optional.of(12), s.get(0));
		assertFalse(s.remove(2));
		assertEquals(Optional.empty(), s.get(2));
		assertEquals(Optional.of(42), s.get(1));
		assertEquals(Optional.of(12), s.get(0));
		assertEquals(2, s.size());
	}

}
