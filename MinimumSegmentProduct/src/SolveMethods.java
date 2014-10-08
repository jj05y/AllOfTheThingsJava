public class SolveMethods {

	private long minSegProd = 0;
	private long currSegProd = 1;
	private int segStart = 0;
	private int segFinish = 0;

	public void bruteForce(OneDArray myArray) {

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = i + 1; j < myArray.getLength(); j++) {
				//System.out.println("NEXT");
				for (int k = i; k <= j; k++) {
					if (i == 0 && j == 1) { // first iteration, set min segment
											// product
						minSegProd = currSegProd = (myArray.getValue(i) * myArray.getValue(j));
					} else {
						currSegProd *= (long) myArray.getValue(k);
						//System.out.println(currSegProd);
						if (currSegProd > minSegProd) {
							break;
						}
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

	public void smart() {
		// TODO
	}

	public int getSegStart() {
		return segStart;
	}

	public int getSegFinish() {
		return segFinish;
	}

}
