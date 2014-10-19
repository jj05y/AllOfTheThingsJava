//the is a subclass of vehicle as it extends it, it is also speed testable as it implements 
//speed testable, this means it MUST have all methods declared in SpeedTestable
//getMaxspeed is declared in the superclass.
public class Truck extends Vehical implements SpeedTestable {

	private int towCapacity;
	
	public Truck(int maxSpeeda, int costa, int towCapacitya) {
		maxSpeed = maxSpeeda;
		cost = costa;
		towCapacity = towCapacitya;
				
	}
	
	public int getSeatingCapacity() {
		return towCapacity;
	}
	
	public String toString(){ //this is called implicitly when this object is put where a string is expected
		return ("Truck max speed: " + maxSpeed);
	}
}