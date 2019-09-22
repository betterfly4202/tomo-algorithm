package week_4.ruby;

/***
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * @author ruby
 * 
 * */
public class ForgRiverOne {
	public int solution(int X, int [] A) {
		boolean[] check = new boolean[X];
		int count = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] > X) continue;
	
			if( !check[A[i]-1] ) count++;		
			check[A[i]-1] = true;
			//System.out.println(i + ", " + Arrays.toString(cnt) + "=>" + Arrays.asList(cnt).contains(0));
			if(count == X) return i;
		}
		
		return -1;
	}
}
