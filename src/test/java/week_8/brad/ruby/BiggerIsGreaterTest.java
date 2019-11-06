package week_8.brad.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import week_8.ruby.BiggerIsGreater;

public class BiggerIsGreaterTest {
	@Test
	public void BiggerIsGreaterTest1() {
		assertEquals(BiggerIsGreater.biggerIsGreater("ab"), "ba");
		assertEquals(BiggerIsGreater.biggerIsGreater("bb"), "no answer");
		assertEquals(BiggerIsGreater.biggerIsGreater("hefg"), "hegf");
		assertEquals(BiggerIsGreater.biggerIsGreater("dhck"), "dhkc");
		assertEquals(BiggerIsGreater.biggerIsGreater("dkhc"), "hcdk");
	}
	
	@Test
	public void BiggerIsGreaterTest2() {
		assertEquals(BiggerIsGreater.biggerIsGreater("lmno"), "lmon");
		assertEquals(BiggerIsGreater.biggerIsGreater("dcba"), "no answer");
		assertEquals(BiggerIsGreater.biggerIsGreater("dcbb"), "no answer");
		assertEquals(BiggerIsGreater.biggerIsGreater("abdc"), "acbd");
		assertEquals(BiggerIsGreater.biggerIsGreater("abcd"), "abdc");
		assertEquals(BiggerIsGreater.biggerIsGreater("fedcbabcd"), "fedcbabdc");
	}
	
	@Test
	public void BiggerIsGreaterTest4() {
		assertEquals(BiggerIsGreater.biggerIsGreater("dcbb"), "no answer");
	}
	
	@Test
	public void BiggerIsGreaterTest3() {
		System.out.println(BiggerIsGreater.getCombination(new char[]{'a','b','c'}, 3).toString());
		System.out.println(BiggerIsGreater.getCombination(new char[]{'a','b','c','d'}, 4).toString());
		System.out.println(BiggerIsGreater.getCombination(new char[]{'a','b','c','d'}, 4).toString());
		System.out.println(BiggerIsGreater.getCombination(new char[]{'a','b','d','c'}, 4).toString());
//		List<String> tmp = BiggerIsGreater.getCombination(new char[]{'a','b','d','c'}, 4);
//		List<String> tmp2 = BiggerIsGreater.getCombination(new char[]{'d','k','h','c'}, 4);
//		Collections.sort(tmp);
//		System.out.println(tmp.toString());
//
//		Collections.sort(tmp2);
//		System.out.println(tmp2.toString());
		
	}
}
