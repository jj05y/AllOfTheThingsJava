public class SolveMethods {

	private long minSegProd = 0;
	private long currSegProd = 1;
	private int segStart = 0;
	private int segFinish = 0;

	public void bruteForce(OneDArray myArray) {

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = i; j < myArray.getLength(); j++) {
				System.out.println("NEXT");
				for (int k = i; k <= j; k++) {
					if (i == 0 && j == 0) { // first iteration, set min segment
											// product
						minSegProd = currSegProd = myArray.getValue(i);
						segStart = i;
						segFinish = j;
					} else {
						currSegProd *= (long) myArray.getValue(k);
						System.out.println(currSegProd);
					}
				}
				if (currSegProd < minSegProd) {
					minSegProd = currSegProd;
					segStart = i;
					segFinish = j;
				}
				currSegProd = 1;
			}

		}
	}

	public void smart(OneDArray myArray) { // this is bad, needs re writing

		/*
		 * Criteria: Greatest odd number of negative ints and neighbouring
		 * positve ints between either: two zeros, a zero and the start a zero
		 * and the end
		 * 
		 * unless, no negative ints, in which case; any segment containing a
		 * zero or the smallest element if no zeros
		 */
		// TODO

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
