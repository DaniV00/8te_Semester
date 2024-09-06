package de.uni_ulm.sp.oop.collections;

class GenericsStackElement<T> {
	
	private T value;
	private GenericsStackElement<T> next;
	
	GenericsStackElement (T value)
	{
		this.value = value;
	}
	
	T getValue()
	{
		return value;
	}
	
	GenericsStackElement<T> getNext()
	{
		return next;
	}
	
	void setNext(GenericsStackElement<T> next)
	{
		this.next = next;
	}
	
	public String toString() {
		return hashCode() + ":" + this.getClass().getSimpleName();
	}
}
