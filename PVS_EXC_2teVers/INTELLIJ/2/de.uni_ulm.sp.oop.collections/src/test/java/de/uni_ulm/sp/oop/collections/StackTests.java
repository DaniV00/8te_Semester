package de.uni_ulm.sp.oop.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StackTests {
	
	@Test
	void coverageTests() {
		Stack s = new Stack();
		assertEquals(0, s.size());
		assertEquals(Optional.empty(), s.pop());
		s.push(12);
		assertEquals(1, s.size());
		assertEquals(Optional.of(12), s.pop());
		assertEquals(0, s.size());
		s.push(14);
		s.push(42);
		assertEquals(2, s.size());
		assertEquals(Optional.of(42), s.pop());
		assertEquals(1, s.size());
		assertEquals(Optional.of(14), s.pop());
		assertEquals(0, s.size());
		s.push(1);
		s.push(2);
		s.push(3);
		assertEquals(3, s.size());
		assertEquals(Optional.of(3), s.pop());
		assertEquals(2, s.size());
		assertEquals(Optional.of(2), s.pop());
		assertEquals(1, s.size());
		assertEquals(Optional.of(1), s.pop());
		assertEquals(0, s.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	void inheritingStackTests() {
		InheritingStack s = new InheritingStack();
		assertEquals(0, s.size());
		assertEquals(Optional.empty(), s.pop());
		s.push(12);
		assertEquals(1, s.size());
		assertEquals(Optional.of(12), s.pop());
		assertEquals(0, s.size());
		s.push(14);
		s.push(42);
		assertEquals(2, s.size());
		assertEquals(Optional.of(42), s.pop());
		assertEquals(1, s.size());
		assertEquals(Optional.of(14), s.pop());
		assertEquals(0, s.size());
		s.push(1);
		s.push(2);
		s.push(3);
		assertEquals(3, s.size());
		assertEquals(Optional.of(3), s.pop());
		assertEquals(2, s.size());
		assertEquals(Optional.of(2), s.pop());
		assertEquals(1, s.size());
		assertEquals(Optional.of(1), s.pop());
		assertEquals(0, s.size());
	}

	
	
	

	@Disabled("does fail on purpose to show problems without generics") 
	@Test 
	void objectProblemsTests() {
		Stack s = new Stack();
		s.push(12);
		s.push("Ulm");

		var element = s.pop();
		assertTrue(element.isPresent());
		Integer v1 = (Integer) element.get();
		assertEquals(v1, 12);

		element = s.pop();	
		assertTrue(element.isPresent());
		String v2 = (String) element.get();
		assertEquals(v2, "Ulm");
		
		if (element.isPresent()) {
			
		} else
		{
			
		}
		element.orElse(42); // Default mitgeben
	}
	
	
	
	
	
	@Test
	void genericsTests() {
		GenericsStack<Integer> s = new GenericsStack<Integer>();
		assertEquals(0, s.length());
		assertEquals(Optional.empty(), s.pop());
		s.push(12);
		assertEquals(1, s.length());
		assertEquals(Optional.of(12), s.pop());
		assertEquals(0, s.length());
		s.push(14);
		s.push(42);
		assertEquals(2, s.length());
		assertEquals(Optional.of(42), s.pop());
		assertEquals(1, s.length());
		assertEquals(Optional.of(14), s.pop());
		assertEquals(0, s.length());
		s.push(1);
		s.push(2);
		s.push(3);
		assertEquals(3, s.length());
		assertEquals(Optional.of(3), s.pop());
		assertEquals(2, s.length());
		assertEquals(Optional.of(2), s.pop());
		assertEquals(1, s.length());
		assertEquals(Optional.of(1), s.pop());
		assertEquals(0, s.length());
	}
}
