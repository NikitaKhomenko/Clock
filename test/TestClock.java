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
	public void testsetHourTimeZone() {
		clock.setHourTimeZone(1);
		Assert.assertEquals(clock.getHour(), -7);
	}
	
	@Test
	public void testAddZeroConcatDigitalClockString() {
		String digitalClock= clock.concatDigitalClockString(6, 5, 2);
		String checkClockTest = "06:05:02";
	
		Assert.assertEquals(digitalClock, checkClockTest);
	}
			
	@Test
	public void testNoZeroConcatDigitalClockString() {
		String digitalClock= clock.concatDigitalClockString(12, 33, 15);
		String checkClockTest = "12:33:15";

		Assert.assertEquals(digitalClock, checkClockTest);
		
	}
	
}
