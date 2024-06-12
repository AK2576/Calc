package com.amena;

/**
 * @author AmenaKassim
 * @date 04/22/2024
 * @param <T> Datatype T that allows to input any datatype.
 * WLinkedlist - Type generics.
 */

public class WLinkedList<T> {

	/**
	 * Instance variable for Node.
	 */
	// TODO: Ensure this is private.
	private Node<T> head;
	
	/**
	 * A default constructor that sets the element to null.
	 */
	public WLinkedList() {
		this.head = null;
	}
	
	/**
	 * A method that checks whether the list is empty or not.
	 * @return Null if the list is empty.
	 */
	public boolean isEmpty() {
		return this.head == null;
	}
	
	/**
	 * A method that adds an element to the front of the list.
	 * @param value New element.
	 */
	public void addToFront(T value) {
		// Create a new Node from the value.
		Node<T> node = new Node<T>(value);
		
		if (this.isEmpty()) {
			this.head = node;
			// I'm done with this function.
			return;
		}
		// Make the new node the head of the list.
		Node<T> oldHead = head;
		node.setNext(oldHead);
		this.head = node;
	}
	
	/**
	 * A method that looks at the front of the list.
	 * @return The first element.
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public T lookAtFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cannot look at the front of an empty list.");
		}
		return this.head.value;
		
	}
	
	/**
	 * A method that removes the first element of the list.
	 */
	public void removeFromFront() {
		if (!isEmpty()) {
			this.head = this.head.next;
		}
	}
	
	/**
	 * A method that adds the first element to the back of the list.
	 * @param value New element.
	 */
	public void addToBackSlow(T value) {
		// Create our new node
		Node<T> node = new Node<T>(value);
		
		// Handle empty case
		if (isEmpty()) {
			this.head = node;
			return;
		}
		
		// We need to find the back of the list.
		// DON'T MESS UP OUR LIST.
		Node<T> curr = this.head;
		while (curr.next != null) {
			curr = curr.next;
		}
		
		// Add our new node to the back's next.
		curr.next = node;
	}
	
	/**
	 * A method that removes the last element from the list.
	 */
	public void removeFromBackSlow() {
		if (!isEmpty()) {
			
			// Check if there is only one element in the list.
			if (this.head.next == null) {
				// Empty the list
				this.head = null;
				return;
			}
			
			// DON'T MESS UP THE LIST.
			Node<T> curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
			}
			curr.next = null;
		}
	}
	
	/**
	 * A method that looks at the back of the list.
	 * @return The last element if the last element is NOT null.
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public T lookAtBack() throws Exception {
		if (isEmpty()) {
			throw new Exception("Cannot look at the front of an empty list.");
		}
		
		// Go to the back of the list.
		// DON'T MESS UP THE LIST.
		Node<T> curr = this.head;
		while (curr.next.next != null) {
			curr = curr.next;
		}
		return curr.value;
	}
	
	@Override
	/**
	 * A toString method that simply calls the toString method of the underlying list.
	 */
	public String toString() {
		if (this.isEmpty()) {
			return "[]";
		}
		
		String listRep = "[";
		
		// "Loop" over every element in the list.
		// DON'T MESS UP OUR LIST.
		Node<T> curr = head;
		while (curr.next != null) {
			
			// Add the current value to the String.
			listRep += curr + ", ";
			// Move up the list.
			curr = curr.next;
		}
		
		// Right now, curr is at the LAST value of the list.
		listRep += curr;
		listRep += "]";
		return listRep;
		
	}
	
	/**
	 * A Node class that creates a new node and sets the element after the current element.
	 * @param <U> Datatype U that allows to input any datatype.
	 */
	// TODO: Ensure this is private.
	private class Node<U> {
		
		/**
		 * Instance variable for value.
		 */
		U value;
		
		/**
		 * Instance variable for next.
		 */
		Node<U> next;
		
		/**
		 * A node method that creates a new node/element.
		 * @param value Takes in any datatype for value.
		 */
		public Node(U value) {
			this.value = value;
			this.next = null;
		}

		/**
		 * A set next method that sets the element after the current element.
		 * @param next Element after the current element.
		 */
		public void setNext(Node<U> next) {
			this.next = next;
		}
		
		@Override
		/**
		 * A toString method that simply calls the toString method of the underlying list.
		 */
		public String toString() {
			return String.valueOf(value);
			// return value + ""
		}
	}
}
