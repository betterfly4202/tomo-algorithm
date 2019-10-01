package week_5.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GoodlandElectricityTest {
	@Test
	public void 마이너스나오는경우() {
		//assertEquals(GoodlandElectricity.pylons(4, new int[]{0,0,0,1,0,0,0,0,0,0,0,1}), -1);
		assertEquals(GoodlandElectricity.pylons(4, new int[]{0,0,0,1,0,0,0,0,0,0,0,1}), -1);
	}
	
	@Test
	public void 공장갯수가나오는경우() {
		assertEquals(GoodlandElectricity.pylons(2, new int[]{0,1,1,1,1,0}), 2);
		assertEquals(GoodlandElectricity.pylons(4, new int[]{0,0,0,1,1,0,0,0,0,0,0,1}), 3);
		assertEquals(GoodlandElectricity.pylons(3, new int[]{0,1,0,0,0,1,1,1,1,1}), 3);
	}
	
}
