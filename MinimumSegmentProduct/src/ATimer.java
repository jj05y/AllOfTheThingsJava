public class ATimer {

	double startTime;
	double finishTime;

	public void startTimer() {
		startTime = System.nanoTime();
	}

	public void stopTimer() {
		finishTime = System.nanoTime();
	}

	public double getTime() {
		return ((finishTime - startTime)/1000000000);
	}

}
