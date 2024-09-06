package de.uni_ulm.sp.oop.collections;

import java.util.Optional;

public class InheritingStack extends LList {

	public Optional<Object> pop() {
		
		if (size() == 0) {
			// empty stack
			return Optional.empty();
		}
		else {
			Optional<Object> o = get(size()-1);
			remove(size()-1);
			return o;
		}
	}

	public void push(Object value) {
		super.add (value);
		//add(value) is also enough
	}
	
	public Object peek () {
		return get(size()-1);
	}
	
	public String toString() {
		return hashCode() + ":InheritingStack";
	}
	
}
