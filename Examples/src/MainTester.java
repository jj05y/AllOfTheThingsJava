
public class MainTester {
	public static void main(String args[]) {
		
		
		Car myCar = new Car(100, 20000, 4);
		Truck myTruck = new Truck(60, 40000, 200);
		
		MaxSpeedTester myTester = new MaxSpeedTester(myCar, myTruck);
		SpeedTestable winner = myTester.whichIsFaster();
		
		System.out.println(winner);
 	}
}
