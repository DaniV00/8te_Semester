package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class GenericsInheritingStackWithChangedOrder<T> extends GenericsLList<T> {

	public Optional<T> pop() {
		
		if (size() == 0) {
			// empty stack
			return Optional.empty();
		}
		else {
			Optional<T> o = peek();
			remove(0);
			return o;
		}
	}

	public void push(T value) {
		super.prepend (value);
	}
	
	@Override
	public void add(T value) {
		super.prepend (value);
	}
	
	public Optional<T> peek () {
		return get(0);
	}
	
}
