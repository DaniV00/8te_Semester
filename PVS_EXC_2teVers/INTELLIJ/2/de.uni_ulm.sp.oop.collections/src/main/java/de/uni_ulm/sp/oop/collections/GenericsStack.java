package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class GenericsStack<T> {

	private GenericsStackElement<T> head;

	public Optional<T> pop() {
		// empty stack
		if (head == null) {
			return Optional.empty();
		}
		// 1 element only
		else if (head.getNext() == null) {
			T o = head.getValue();
			head = null;
			return Optional.of(o);
		} else {
			var elem = head;
			// look two into the future
			while (elem.getNext().getNext() != null) {
				elem = elem.getNext();
			}
			// elem is 2nd-to-last
			T o = elem.getNext().getValue();
			elem.setNext(null);
			return Optional.of(o);
		}
	}

	public void push(T value) {
		// empty stack
		if (head == null) {
			var elem = new GenericsStackElement<>(value);
			head = elem;
		} else {
			var elem = head;
			// find end
			while (elem.getNext() != null) {
				elem = elem.getNext();
			}
			elem.setNext(new GenericsStackElement<>(value));
		}
	}
	
	public int length() 
	{
		int i = 0;
		var elem = head; 
		while (elem != null) {
			elem = elem.getNext();
			i++;
		}
		return i;
	}

	public String toString() {
		return hashCode() + ":" + this.getClass().getSimpleName();
	}
}
