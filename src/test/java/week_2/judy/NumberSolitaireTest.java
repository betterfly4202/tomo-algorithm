package week_2.judy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by ChaYujin
 * Date : 2019.08.27
 */
public class NumberSolitaireTest {
    static NumberSolitaire  ms;
    
    @BeforeClass
    public static void setup() {
    	ms = new NumberSolitaire();
    }

    @Test
    public void 검증(){
    	assertThat( ms.solution(new int[] {1,-2,0,9,-1,-2}) , is(8) );
    }
}