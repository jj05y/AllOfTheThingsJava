public class MaxSpeedTester {

	SpeedTestable thing1;
	SpeedTestable thing2;

	public MaxSpeedTester(SpeedTestable t1, SpeedTestable t2) {
		thing1 = t1;
		thing2 = t2;
	}

	public SpeedTestable whichIsFaster() {
		if (thing1.getMaxSpeed() < thing2.getMaxSpeed()) {
			return thing2;
		} else
			return thing1;
	}
}