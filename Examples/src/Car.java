
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
	
	public String toString(){
		return ("Car max speed: " + maxSpeed);
	}
}
