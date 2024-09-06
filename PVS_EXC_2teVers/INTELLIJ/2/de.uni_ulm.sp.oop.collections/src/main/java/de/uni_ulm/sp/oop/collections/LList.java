package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class LList {

	private ListElement head;
	
	ListElement getHead() {
		return head;
	}


	public Optional<Object> get(int index) {
		// element at index does not exist
		if (size() <= index) {
			return Optional.empty();
		}
		// traverse until the correct place and return value
		int i = 0;
		ListElement current = head;
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
			ListElement current = head;
			while (i < index-1) {
				current = current.getNext();
				i++;
			}
			current.setNext(current.getNext() != null ? current.getNext().getNext() : null);
		}
		return true;
	}

	public void add(Object value) {
		// empty list
		if (head == null) {
			ListElement elem = new ListElement(value);
			head = elem;
		} else {
			ListElement elem = head;
			// find end
			while (elem.getNext() != null) {
				elem = elem.getNext();
			}
			elem.setNext(new ListElement(value));
		}
	}
	
	public int size() 
	{
		int i = 0;
		ListElement elem = head; 
		while (elem != null) {
			elem = elem.getNext();
			i++;
		}
		return i;
	}

	public String toString() {
		return hashCode() + ":LList";
	}
}
