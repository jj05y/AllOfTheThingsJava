package examplesAndTesters;

import structures.LinkedStack;

public class PCQ2ListStackExample {
	
	public static void main (String[] args) {
		
		LinkedStack<Character> s = new LinkedStack<Character>();
		
		System.out.println(s);
		s.push ('e');
		System.out.println(s);
		s.push ('s');
		System.out.println(s);
		s.push ('c');
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ('u');
		System.out.println(s);
		s.push ('a');
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ('o');
		System.out.println(s);
		s.push ('t');
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ('h');
		System.out.println(s);
		

		
	}


}
