package week_7.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KangarooTest {
	@Test
	public void 캥거루() {
		assertEquals(Kangaroo.kangaroo(0, 3, 4, 2), "YES");
		assertEquals(Kangaroo.kangaroo(5, 4, 8, 3), "YES");
		assertEquals(Kangaroo.kangaroo(0, 2, 5, 3), "NO");
		assertEquals(Kangaroo.kangaroo(6644,5868,8349,3477), "NO");
	}
}
