package de.uni_ulm.sp.oop.collections;

class ListElement {
	private Object value;
	private ListElement next;

	ListElement (Object value)
	{
		this.value = value;
	}

	Object getValue() {
		return value;
	}

	ListElement getNext() {
		return next;
	}

	void setNext(ListElement next) {
		this.next = next;
	}

	public String toString() {
		return hashCode() + ":ListElement";
	}
}


