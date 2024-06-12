package com.amena;

/**
 * @author AmenaKassim
 * @date 05/04/2024
 * @param <T> A changeable datatype.
 * A WQueue program that enqueues and dequeues a datatype
 */

public class WQueue<T> {

	/**
	 * Instance variable of WLinkedList.
	 */
	private WLinkedList<T> list = new WLinkedList<T>();

	/**
	 * A default constructor for Wqueue.
	 */
	public WQueue() {
		this.list = new WLinkedList<T>();
	}

	/**
	 * An enqueue method that adds a String to the back of the list.
	 * @param string Adds a string to the back of the list.
	 */
	public void enqueue(T string) {
		list.addToBackSlow(string);
	}

	/**
	 * A dequeue method that looks at the first element then removes it.
	 * @return First element.
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public T dequeue() throws Exception {
		T frontVal = (T) list.lookAtFront();
		list.removeFromFront();
		return frontVal;
	}

	/**
	 * A peek method that looks at the first element.
	 * @return The first element of the list.
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public T peek() throws Exception {
		return (T) list.lookAtFront();
	}

	/**
	 * A toString method that simply calls the toString method of the underlying list.
	 */
	public String toString() {
		return list.toString();
	}

	/**
	 * An isEmpty() method that calls the isEmpty() method of the underlying list.
	 * @return Wether or not the list is empty.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
}