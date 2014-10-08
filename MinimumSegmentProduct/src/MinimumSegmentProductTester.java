
public class MinimumSegmentProductTester {
	public static void main (String args[]) {
		
		OneDArray myArray = new OneDArray();
		SolveMethods mySolves = new SolveMethods();
		ATimer myTimer = new ATimer();
		
		myArray.showArray("Integer array");
		
		myTimer.startTimer();
		mySolves.bruteForce(myArray);
		myTimer.stopTimer();
		
		myArray.showArray("Brute Force\nSegment with minimum product", mySolves.getSegStart(), mySolves.getSegFinish(), myTimer.getTime());
		
		mySolves.reset();
		
		myTimer.startTimer();
		mySolves.smart(myArray);
		myTimer.stopTimer();
		
		myArray.showArray("Smart algorithm\nSegment with minium product", mySolves.getSegStart(), mySolves.getSegFinish(), myTimer.getTime());
				
	}
}
