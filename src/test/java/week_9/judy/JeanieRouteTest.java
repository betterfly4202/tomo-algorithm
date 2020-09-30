package week_9.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class JeanieRouteTest {
    @Test
    public void 연속된_면적구하기(){
    	//System.out.println(BiggerIsGreater.biggerIsGreater("ab"));
    	//System.out.println(BiggerIsGreater.biggerIsGreater("bb"));
    	//System.out.println(BiggerIsGreater.biggerIsGreater("hefg"));
    	//System.out.println(BiggerIsGreater.biggerIsGreater("dhck"));
    	int inf = Integer.MAX_VALUE;
    	System.out.println(JeanieRoute.jeanisRoute(new int[] {1,3,4}, new int[][] {
    		{1,2,1},
    		{2,3,2},
    		{2,4,2},
    		{3,5,3}} ));
    }
}
