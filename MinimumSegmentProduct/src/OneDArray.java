import java.util.Random;

import javax.swing.JOptionPane;

public class OneDArray {

	public int intArray[] = new int[20];

	public OneDArray() {
		Random rand = new Random();
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (rand.nextInt(9))
					* (int) Math.pow(-1, rand.nextInt(9));
		}
	}

	public void showArray(String message) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intArray.length; i++) {

			if ((i % 10) == 0 && i != 0) {
				sb.append("\n");
			}
			if (intArray[i] >= 0) {
				sb.append(String.format("%03d  ", intArray[i]));
			} else {
				sb.append(String.format("%04d ", intArray[i]));
			}

		}
		sb.append("\n\n" + message);
		JOptionPane.showMessageDialog(null, sb);
	}

	public void showArray(String message, int a, int b, double time) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < intArray.length; i++) {

			if ((i % 10) == 0 && i != 0) {
				sb.append("\n");
			}
			if (i == a) {
				sb.append("[ ");
			}
			if (intArray[i] >= 0) {
				sb.append(String.format("%03d  ", intArray[i]));
			} else {
				sb.append(String.format("%04d ", intArray[i]));
			}
			if (i == b) {
				sb.append("] ");
			}

		}
		sb.append("\n\n" + message + "\n Total time: " + time + " seconds.");
		JOptionPane.showMessageDialog(null, sb);
	}



	public int getValue(int i) {
		return intArray[i];
	}

	public int getLength() {
		return intArray.length;
	}

}
