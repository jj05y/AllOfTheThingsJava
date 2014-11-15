package examplesAndTesters;

import structures.ArrayStack;

public class PCQ3ArrayStackExample {
	
	public static void main (String[] args) {
		
		ArrayStack<String> s = new ArrayStack<String>();
		
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
