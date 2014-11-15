package structures;

import interFaces.Stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {

	private Node<E> top;

	/* I have not implemented a size variable, instead, there is a method which
	 returns it */

	@SuppressWarnings("hiding")
	public class Node<E> {
		E element;
		Node<E> next;

		public Node(E x) {
			element = x;
		}

	}

	public LinkedStack() {
		top = null;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			int size = 0;
			Node<E> node = top;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	}

	public boolean isEmpty() {
		return (top == null);
	}

	@SuppressWarnings("unchecked")
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return (E) top;
		}
	}

	public void push(E element) {

		Node<E> node = new Node<E>(element);
		node.next = top;
		top = node;
	}

	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
		Node<E> node = top;
		top = top.next;
		return node.element;
		}
	}

	public String toString() { //this returns a string with the bottom of the stack listed first
		StringBuilder message = new StringBuilder();
		message.append("Size: " + size() + ":\t");
		
		E[] tempArr = (E[]) new Object[size()];
		
		Node<E> node = top;
		int i = 0;
		while (node != null) {
			tempArr[i] = node.element;
			i++;
			node = node.next;
		}
		for (int j = tempArr.length-1; j >= 0; j--) {
		message.append(tempArr[j] + " ");
		}
		return new String(message);
	}

}
