package examplesAndTesters;

import interFaces.Position;
import structures.LinkedList;
import exceptions.BoundaryViolationException;
import exceptions.ListEmptyException;


public class W5Q6LinkedListExample {
	public static void main(String[] args) throws BoundaryViolationException, ListEmptyException {
		LinkedList myList = new LinkedList();
		Position p;
		Position q;
		
		System.out.println(myList);
		p = myList.insertFirst('n');
		System.out.println(myList);
		q = myList.insertAfter(p, 'r');
		System.out.println(myList);
		p = myList.insertBefore(q, 'e');
		System.out.println(myList);
		q = myList.insertFirst('p');
		System.out.println(myList);
		q = myList.insertAfter(q, 'k');
		System.out.println(myList);
		myList.insertBefore(p, 'n');
		System.out.println(myList);
		p = myList.insertBefore(p, 'n');
		System.out.println(myList);
		myList.insertAfter(q, 'a');
		System.out.println(myList);
		myList.replace(q, 'p');
		System.out.println(myList);
		myList.remove(p);
		System.out.println(myList);
		p = myList.insertFirst('s');
		System.out.println(myList);
		myList.remove(myList.next(p));
		System.out.println(myList);
		
		System.exit(0);
		
	}
}
