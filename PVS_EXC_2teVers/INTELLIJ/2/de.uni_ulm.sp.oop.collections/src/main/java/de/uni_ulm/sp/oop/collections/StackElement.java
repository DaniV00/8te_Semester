package de.uni_ulm.sp.oop.collections;

class StackElement {
	
	private Object value;
	private StackElement next;
	
	StackElement (Object value)
	{
		this.value = value;
	}
	
	Object getValue()
	{
		return value;
	}
	
	StackElement getNext()
	{
		return next;
	}
	
	void setNext(StackElement next)
	{
		this.next = next;
	}
	
	public String toString() {
		return hashCode() + ":StackElement";
	}
}
