package ducksweep;

public class FlagCounter {
	private int numFlags;
	
	public FlagCounter () {
		numFlags = 0;
	}
	
	public void addFlag() {
		numFlags++;
	}
	
	public void removeFlag() {
		numFlags--;
	}
	
	public String getNumFlags() {
		
		return  ("Number of Flags is: " + numFlags);
	}
	
	public void reset() {
		numFlags = 0;
	}
}
