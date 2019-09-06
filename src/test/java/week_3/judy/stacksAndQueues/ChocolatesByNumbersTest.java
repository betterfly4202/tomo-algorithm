package week_3.judy.stacksAndQueues;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import week_3.judy.ChocolatesByNumbers;

public class ChocolatesByNumbersTest {

    static ChocolatesByNumbers  solution;
    
    @BeforeClass
    public static void setup() {
    	solution = new ChocolatesByNumbers();
    }

    @Test
    public void 최대공약수구하기(){
    	assertThat( solution.gcd_using_divding(50, 20) , is(10) );
    	assertThat( solution.gcd_using_divding(24, 16) , is(8) );
    	assertThat( solution.gcd_using_divding(100, 25) , is(25) );
    }

    @Test
    public void 초콜릿먹은갯수(){
    	assertThat( solution.solution(10, 4) , is(5) );
    }
}
