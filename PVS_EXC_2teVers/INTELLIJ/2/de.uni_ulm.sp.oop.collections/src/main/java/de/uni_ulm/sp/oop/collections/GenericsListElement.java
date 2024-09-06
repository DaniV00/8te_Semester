package de.uni_ulm.sp.oop.collections;

class GenericsListElement<T> {
	private T value;
	private GenericsListElement<T> next;

	GenericsListElement (T value)
	{
		this.value = value;
	}

	T getValue() {
		return value;
	}

	GenericsListElement<T> getNext() {
		return next;
	}

	void setNext(GenericsListElement<T> next) {
		this.next = next;
	}

	public String toString() {
		return hashCode() + ":" + this.getClass().getSimpleName();
	}
}


