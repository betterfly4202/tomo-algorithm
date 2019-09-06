package week_3.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BracketsTest {
	private Brackets b = new Brackets();
	
	@Test
	public void test() {
		assertEquals(b.solution(" {[() ()]} "), 1);
		assertEquals(b.solution("([) ()] "), 0);
		assertEquals(b.solution("("), 0);
		assertEquals(b.solution("([]() () ]]]]]]] "), 0);
		assertEquals(b.solution("[]() () [[[[[[[[]]]]]]]] "), 1);
		assertEquals(b.solution("{{{{{{{222{{44{dd}}}}}}}}}}({}{}{}{{}}[])"), 1);
		assertEquals(b.solution("2221111AABBB"), 1);
		assertEquals(b.solution("(TT)(TT)(TT)(TT)(TT)(TT)(TT)(TT)(TT)(TT)(TT)"), 1);
		
	}
}
