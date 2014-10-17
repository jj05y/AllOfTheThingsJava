import java.util.Random;

import javax.swing.JOptionPane;

public class BubbleSort {
	public static void main(String args[]) {
		int[] myInts = new int[30];
		
		// first populate array randomly and display integers.
		populate(myInts);
		//display the array
		JOptionPane.showMessageDialog(null, buildMessage(myInts));
		// now the bubble sort,
		bubbleSort(myInts);
		//display the array
		JOptionPane.showMessageDialog(null, buildMessage(myInts));

	}
	//bubbleSort!
	public static void bubbleSort(int[] myInts) {

		boolean Swapped = true;
		while (Swapped) {
			Swapped = false;
			for (int i = 0; i < myInts.length - 1; i++) {
				if (myInts[i] > myInts[i + 1]) {
					swap(myInts, i); 
					Swapped = true;
				}
			}
		}
	}

	//swaps the (i)th and (i+1)th elements in the array.
	public static void swap(int[] myInts, int i) {
		int temp = myInts[i];
		myInts[i] = myInts[i + 1];
		myInts[i + 1] = temp;
	}

	public static StringBuilder buildMessage(int[] myInts){
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < myInts.length; i++) {
			message.append(myInts[i] + " ");
		}
		return message;
	}
	
	public static void populate(int[] myInts) {

		Random rand = new Random();
		for (int i = 0; i < myInts.length; i++) {
			myInts[i] = rand.nextInt(100);
		}
	}
}
