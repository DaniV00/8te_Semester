package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class GenericsInheritingStack<T> extends GenericsLList<T> {

	public Optional<T> pop() {
		
		if (size() == 0) {
			// empty stack
			return Optional.empty();
		}
		else {
			Optional<T> o = get(size()-1);
			remove(size()-1);
			return o;
		}
	}

	public void push(T value) {
		super.add (value);
		//add(value) is also enough
	}
	
	public Optional<T> peek () {
		return get(size()-1);
	}
	
}
