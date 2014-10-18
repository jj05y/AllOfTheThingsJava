import java.util.Random;

import javax.swing.JOptionPane;

public class SortAlgorithms {
	public static void main(String args[]) {
		int[] myInts = new int[30];

		// first populate array randomly and display integers.
		randomize(myInts);
		// display the array
		JOptionPane
				.showMessageDialog(null, buildMessage(myInts, "Random Ints"));
		// now the bubble sort,
		bubbleSort(myInts);
		// display the array
		JOptionPane.showMessageDialog(null,
				buildMessage(myInts, "Bubble Sorted Ints"));

		// re-random
		randomize(myInts);
		JOptionPane
				.showMessageDialog(null, buildMessage(myInts, "Random Ints"));
		// now the bubble sort,
		selectionSort(myInts);
		// display the array
		JOptionPane.showMessageDialog(null,
				buildMessage(myInts, "Selection Sorted Ints"));

	}

	// bubbleSort!
	private static void bubbleSort(int[] myInts) {

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

	// selectionSort!
	private static void selectionSort(int[] myInts) {
		int minI;
		int i;
		int j;

		for (i = 0; i < myInts.length - 1; i++) {
			minI = i;
			for (j = i + 1; j < myInts.length; j++) {
				if (myInts[j] < myInts[minI]) {
					minI = j;
				}
			}
			if (minI != i) {
				swap(myInts, i, minI);
			}
		}
	}

	// swaps the (i)th and (i+1)th elements in the array.
	private static void swap(int[] myInts, int i) {
		int temp = myInts[i];
		myInts[i] = myInts[i + 1];
		myInts[i + 1] = temp;
	}

	// swaps the (i)th and j(th) elements in an array
	private static void swap(int[] myInts, int i, int j) {
		int temp = myInts[i];
		myInts[i] = myInts[j];
		myInts[j] = temp;
	}

	private static StringBuilder buildMessage(int[] myInts, String sortType) {
		StringBuilder message = new StringBuilder();
		message.append(sortType + ":\n");
		for (int i = 0; i < myInts.length; i++) {
			message.append(myInts[i] + " ");
		}
		return message;
	}

	private static void randomize(int[] myInts) {

		Random rand = new Random();
		for (int i = 0; i < myInts.length; i++) {
			myInts[i] = rand.nextInt(100);
		}
	}
}
