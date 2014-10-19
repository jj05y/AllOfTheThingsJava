//the is a subclass of vehicle as it extends it, it is also speed testable as it implements 
//speed testable, this means it MUST have all methods declared in SpeedTestable
public class Car extends Vehical implements SpeedTestable{

	private int seatingCapacity;
	
	public Car(int maxSpeeda, int costa, int seatingCapacitya) {
		maxSpeed = maxSpeeda;
		cost = costa;
		seatingCapacity = seatingCapacitya;
				
	}
	
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	
	public String toString(){ //this is called implicitly when this object is put where a string is expected
		return ("Car max speed: " + maxSpeed);
	}
}
