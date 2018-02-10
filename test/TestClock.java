import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clockMachine.Clock;

public class TestClock {
	
	private Clock clock;
	
	@Before
	public void SetUp() throws Exception {
		clock = new Clock();
	}
	
	@Test
	public void testTimeToDegrees() {
		//Test for 24 hours
		int degrees = 90;
		float time = 3.00f;
		Assert.assertEquals(clock.timeToDegrees(time), degrees);
		float nextTime = 15.00f;
		Assert.assertEquals(clock.timeToDegrees(nextTime), degrees);
	}
	
	@Test
	public void TestTimeToDegrees() {
		float time = 7.50f;
		int degrees = 225;
		Assert.assertEquals(clock.timeToDegrees(time), degrees);
				
	}
	
}
