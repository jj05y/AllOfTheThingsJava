
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
	
	public String toString(){
		return ("Truck max speed: " + maxSpeed);
	}
}