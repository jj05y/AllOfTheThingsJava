public class SolveMethods {

	private long minSegProd = 0;
	private long currSegProd = 1;
	private int segStart = 0;
	private int segFinish = 0;

	public void bruteForce(OneDArray myArray) {

		for (int i = 0; i < myArray.getLength(); i++) {
			for (int j = i; j < myArray.getLength(); j++) {
				// System.out.println("NEXT");
				for (int k = i; k <= j; k++) {
					if (i == 0 && j == 0) { // first iteration, set min segment
											// product
						minSegProd = currSegProd = myArray.getValue(i);
						segStart = i;
						segFinish = j;
					} else {
						currSegProd *= (long) myArray.getValue(k);
						// System.out.println(currSegProd);
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

	public void smart(OneDArray myArray) {

		int n = 0;
		minSegProd = 1;
		long d = 1;
		long g = 1;

		do {
	
			if (0 <= myArray.getValue(n)) {
				
				n++;
				minSegProd = Math.min(minSegProd, Math.min((d * myArray.getValue(n)), 1));
				d = Math.min((d * myArray.getValue(n)), 1);
				g = Math.max(g * myArray.getValue(n), 1);
				
			} else if (myArray.getValue(n) <= 0) {
				
				n++;
				minSegProd = Math.min(minSegProd, Math.min((g * myArray.getValue(n)), 1));
				d = Math.min((g * myArray.getValue(n)), 1);
				g = Math.max(d * myArray.getValue(n), 1);
			}
		} while (n < myArray.getLength()-1);
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

	public long getMinSegProd() {
		return minSegProd;

	}

}
