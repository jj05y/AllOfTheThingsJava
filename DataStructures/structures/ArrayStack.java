package structures;

import interFaces.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{

	private E[] A;
	private int top = -1;
	//I have not implemented a size variable, instead, there is a method which returns it

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		A = (E[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		A = (E[]) new Object[1000]; // default size
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return A[top];
		}
	}

	public void push(E element) {
		if (size() == A.length) {
			A = Arrays.copyOf(A, A.length * 2);
		}
		top++;
		A[top] = element;
		// System.out.println("pushed" + A[top]);
	}

	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			E temp = A[top];
			A[top] = null;
			top--;
			return temp;
		}
	}

	public String toString() { //this returns a string with the bottom of the stack listed first

		StringBuilder sb = new StringBuilder();
		sb.append("Size: " + size() + ":\t");
		for (int i = 0; i <= top; i++) {
			sb.append(A[i] + " ");
		}

		return new String(sb);
	}
}
