package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class GenericsLList<T> {

	private GenericsListElement<T> head;
	
	GenericsListElement<T> getHead() {
		return head;
	}


	public Optional<T> get(int index) {
		// element at index does not exist
		if (size() <= index) {
			return Optional.empty();
		}
		// traverse until the correct place and return value
		var i = 0;
		var current = head;
		while (i < index) {
			current = current.getNext();
			i++;
		}
		return Optional.of(current.getValue());
	}
	
	public boolean remove(int index) {
		// element at index does not exist
		if (size() <= index) {
			return false;
		}
		if (index == 0 ) {
			// remove first element by setting head to second element 
			head = head.getNext();
		}
		else {
			// traverse until the element just before index 
			int i = 0;
			var current = head;
			while (i < index-1) {
				current = current.getNext();
				i++;
			}
			current.setNext(current.getNext() != null ? current.getNext().getNext() : null);
		}
		return true;
	}

	public void add(T value) {
		// empty list
		if (head == null) {
			var elem = new GenericsListElement<T>(value);
			head = elem;
		} else {
			var elem = head;
			// find end
			while (elem.getNext() != null) {
				elem = elem.getNext();
			}
			elem.setNext(new GenericsListElement<T>(value));
		}
	}
	
	public void prepend(T value) {
		// empty list
		if (head == null) {
			var elem = new GenericsListElement<T>(value);
			head = elem;
		} else {
			var newHead = new GenericsListElement<T>(value);
			newHead.setNext(head);
			this.head = newHead;
		}
	}
	
	public void add(T[] values) {
		for (T t : values) {
			this.add(t);
		}
	}
	
	public int size() 
	{
		var i = 0;
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
