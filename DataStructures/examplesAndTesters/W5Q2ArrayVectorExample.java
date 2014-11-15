package examplesAndTesters;

import structures.ArrayVector;
import exceptions.RankOutOfBoundsException;

public class W5Q2ArrayVectorExample {
	public static void main (String[] args) throws RankOutOfBoundsException {
		
		ArrayVector myVector = new ArrayVector(4);

		System.out.println(myVector);
		myVector.insertAtRank(0, 'c');
		System.out.println(myVector);
		myVector.insertAtRank(1, 'a');
		System.out.println(myVector);
		myVector.insertAtRank(2, 't');
		System.out.println(myVector);
		myVector.removeAtRank(0);
		System.out.println(myVector);
		myVector.insertAtRank(2, 'h');
		System.out.println(myVector);
		myVector.insertAtRank(3, 'o');
		System.out.println(myVector);
		myVector.removeAtRank(0);
		System.out.println(myVector);
		myVector.insertAtRank(3, 'u');
		System.out.println(myVector);
		myVector.insertAtRank(4, 's');
		System.out.println(myVector);
		myVector.removeAtRank(0);
		System.out.println(myVector);
		myVector.insertAtRank(4, 'e');
		System.out.println(myVector);

		System.exit(0);
	}
}
