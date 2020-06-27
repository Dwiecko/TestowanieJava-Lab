package exampleTableJBehabe.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exampleTableJBehabe.Power;

public class PowerTest {
	
	private Power power;

	@Before
	public void setUp() throws Exception {
		power = new Power();
	}
	
	@Test
	public void testPowerOne() {
		assertThat(power.powers(0,1),hasItems(1,2));
	}
	
	@Test
	public void testPowerOneContains() {
		assertThat(power.powers(0,1),contains(1,2));
	}
	
	
	@Test
	public void testPowerOneSize() {
		assertThat(power.powers(0,1),hasSize(2));
	}

	@After
	public void tearDown() throws Exception {
		power = null;
	}


}
