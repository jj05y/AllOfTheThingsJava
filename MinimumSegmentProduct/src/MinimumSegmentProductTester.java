
public class MinimumSegmentProductTester {
	public static void main (String args[]) {
		
		OneDArray myArray = new OneDArray();
		SolveMethods mySolves = new SolveMethods();
		
		myArray.showArray("Integer array");
		
		mySolves.bruteForce(myArray);
		
		myArray.showArray("Segment with minimum product", mySolves.getSegStart(), mySolves.getSegFinish());
				
	}
}
