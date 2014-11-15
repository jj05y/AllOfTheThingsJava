package examplesAndTesters;

import structures.ArrayStack;
import structures.LinkedStack;

public class StackTest {

	public static void main(String[] args) {

		char[] toStackChar = { 'A', 'B', 'C' };
		int[] toStackInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// chars
		ArrayStack<Character> myArrayStack = new ArrayStack<Character>(10);
		LinkedStack<Character> myLinkedStack = new LinkedStack<Character>();

		// ints
		ArrayStack<Integer> myIntArrayStack = new ArrayStack<Integer>();
		LinkedStack<Integer> myIntLinkedStack = new LinkedStack<Integer>();

		// empty stack testing
		// myArrayStack.pop();
		// myArrayStack.top();

		// chars testing
		System.out.println("Array Based Stack:");
		System.out.println(myArrayStack);
		for (char c : toStackChar) {
			myArrayStack.push(c);
			System.out.println(myArrayStack);
		}

		System.out.println("\nLinked List Based Stack:");
		System.out.println(myLinkedStack);
		for (char c : toStackChar) {
			myLinkedStack.push(c);
			System.out.println(myLinkedStack);
		}

		// ints testing
		System.out.println("\nPopping Odd Numbers From Array Based Stack");
		System.out.println(myIntArrayStack);
		for (int i : toStackInt) {
			myIntArrayStack.push(i);
			System.out.println(myIntArrayStack);
			if (i % 2 == 1 && myIntArrayStack.size() != 0) { 
				// testing,, popping odd numbers as 1 - 10 are pushed
				myIntArrayStack.pop();
				System.out.println(myIntArrayStack);
			}
		}

		System.out.println("\nPopping Even Numbers Frrom Linked List Based Stack");
		System.out.println(myIntLinkedStack);
		for (int i : toStackInt) {
			myIntLinkedStack.push(i);
			System.out.println(myIntLinkedStack);
			if (i % 2 == 0 && myIntLinkedStack.size() != 0) { 
				// testing,, popping even numbers as 1 - 10 are pushed
				myIntLinkedStack.pop();
				System.out.println(myIntLinkedStack);
			}
		}

	}

}
