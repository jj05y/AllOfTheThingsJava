//this is an interface, think of it as a contract, "if i implement speedtestable, i MUST declare these methods."
public interface SpeedTestable {
	
	int getMaxSpeed();// these methods are abstract,
	String toString();// they have no access modifier, they are public by default.

}
