package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class Stack {

	private StackElement head;

	public Optional<Object> pop() {
		// empty stack
		if (head == null) {
			return Optional.empty();
		}
		// 1 element only
		else if (head.getNext() == null) {
			Object o = head.getValue();
			head = null;
			return Optional.of(o);
		} else {
			StackElement elem = head;
			// look two into the future
			while (elem.getNext().getNext() != null) {
				elem = elem.getNext();
			}
			// elem is 2nd-to-last
			Object o = elem.getNext().getValue();
			elem.setNext(null);
			return Optional.of(o);
		}
	}

	public void push(Object value) {
		// empty stack
		if (head == null) {
			StackElement elem = new StackElement(value);
			head = elem;
		} else {
			StackElement elem = head;
			// find end
			while (elem.getNext() != null) {
				elem = elem.getNext();
			}
			elem.setNext(new StackElement(value));
		}
	}
	
	public int size() 
	{
		int i = 0;
		StackElement elem = head; 
		while (elem != null) {
			elem = elem.getNext();
			i++;
		}
		return i;
	}

	public String toString() {
		return hashCode() + ":Stack";
	}
	
	StackElement getHead() {
		return head;
	}
}
