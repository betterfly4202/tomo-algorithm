package week_7.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class KangarooTest {
    @Test
    public void TopView숫자들(){
    	assertThat( Kangaroo.kangaroo(0, 3, 4, 2), is("YES") );
    	assertThat( Kangaroo.kangaroo(0, 2, 5, 3), is("NO") );
    	assertThat( Kangaroo.kangaroo(43, 2, 70, 2), is("NO") );
    }
}
