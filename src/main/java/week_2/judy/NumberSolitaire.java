package week_2.judy;

/**
 * reference : https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 * use Dynamic Programming
 */
public class NumberSolitaire {

	public static void main(String[] args) {
		NumberSolitaire ms = new NumberSolitaire();
		System.out.println( ms.solution(new int[] {1,-2,0,9,-1,-2}) );
	}

    public int solution(int[] A) {
    	byte dice_maxnum=6;
    	int cur_sum=0;
    	int loof_last_index = A.length-2;
    	
    	cur_sum=A[0];
    	for( int i=1, cur_position=1; i<=loof_last_index; i=cur_position) {
    		for( int j=cur_position; j<i+dice_maxnum; j++ ) {
    			if( j > loof_last_index ) {
    				cur_position = j;
    				break;
    			}
    			
    			if( cur_sum < cur_sum+A[j] ) {
    				cur_sum = cur_sum+A[j];
    				cur_position = j;
    			}
    		}
    	}
    	return cur_sum+A[A.length-1];
    }
}
