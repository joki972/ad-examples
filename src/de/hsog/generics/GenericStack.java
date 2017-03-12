package de.hsog.generics;


/**
 * @author strahasc
 * @param <T> = type parameter
 * no boundary checks!
 */
public class GenericStack<T> {

	private int index;
	private T[] data;

	public GenericStack(int size) {
		data = (T[]) new Object[size];
		index = 0;
	}

	public void push(T obj) {
		data[index++] = obj;
	}

	public T pop() {
		return data[--index];
	}
}
