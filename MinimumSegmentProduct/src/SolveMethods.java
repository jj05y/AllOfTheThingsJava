public class SolveMethods {

	private long minSegProd = 0;
	private long currSegProd = 1;
	private int segStart = 0;
	private int segFinish = 0;

	public void bruteForce(OneDArray myArray) {

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = i + 1; j < myArray.getLength(); j++) {
				System.out.println("NEXT");
				for (int k = i; k <= j; k++) {
					if (i == 0 && j == 1) { // first iteration, set min segment
											// product
						minSegProd = currSegProd = (myArray.getValue(i) * myArray
								.getValue(j));
					} else {
						currSegProd *= (long) myArray.getValue(k);
						System.out.println(currSegProd);
						// if (currSegProd > minSegProd) {
						// break;
						// }
					}
				}
				if (currSegProd <= minSegProd) {
					minSegProd = currSegProd;
					segStart = i;
					segFinish = j;
				}
				currSegProd = 1;
			}

		}
	}

	public void smart(OneDArray myArray) { // this is bad, needs re writing

		boolean doneNimp = false;
		long nimp = 1; // numbers from the front
		int nimpCutOff = 0;
		boolean doneNump = false;
		long nump = 1; // numbers from the back
		int numpCutOff = 0;

		for (int i = 0; i < myArray.getLength(); i++) {

			if (!(doneNimp)) {
				if (myArray.getValue(i) <= 0) {
					doneNimp = true;
					nimpCutOff = i;
				}
				nimp *= myArray.getValue(i);
			}

			if (!(doneNump)) {
				if (myArray.getValue(myArray.getLength() - 1 - i) <= 0) {
					doneNump = true;
					numpCutOff = i;
				}
				nump *= myArray.getValue(i);
			}

		}

		segStart = nimpCutOff;
		segFinish = numpCutOff;

	}

	public void reset() {
		minSegProd = 0;
		currSegProd = 1;
		segStart = 0;
		segFinish = 0;
	}

	public int getSegStart() {
		return segStart;
	}

	public int getSegFinish() {
		return segFinish;
	}

}
