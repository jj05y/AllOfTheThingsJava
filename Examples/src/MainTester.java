//main is here
public class MainTester {
	public static void main(String args[]) {
		
		
		Car myCar = new Car(100, 20000, 4); //(speed, cost, seating capacity)
		Truck myTruck = new Truck(60, 40000, 200); //(speed, cost, towing capacity)
		
		MaxSpeedTester myTester = new MaxSpeedTester(myCar, myTruck); //parameters are speedTestable.
		SpeedTestable winner = myTester.whichIsFaster(); //WOO! polymorphism.
		
		System.out.println(winner); //this will call the toString method implicitly.
 	}
}
