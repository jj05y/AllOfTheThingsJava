package examplesAndTesters;

import structures.LinkedStack;

public class PCQ3ListStackExample {
	
	public static void main (String[] args) {
		
		LinkedStack<String> s = new LinkedStack<String>();
		
		System.out.println(s);
		s.push ("Ireland");
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ("England");
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ("Wales");
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push("Scotland");
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push ("France");
		System.out.println(s);
		s.push("Germany");
		System.out.println(s);

	}

}
