package week1;

/**
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclo

출처 : https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class Sorting_Quiz1 {
    public static void main(String[] args) {
        Sorting_Quiz1 s = new Sorting_Quiz1();
        System.out.println(s.solution(new int[] {-1,1,2,-2,5,6})+", 답:60");
        System.out.println(s.solution(new int[] {-10,-2,-4})+", 답:-80");
        System.out.println(s.solution(new int[] {2,100,3,-1000})+", 답:600");
        System.out.println(s.solution(new int[] {-2,-3,-5,-6,0})+", 답:0");
        System.out.println(s.solution(new int[] {4,5,1,0})+", 답:20");
        System.out.println(s.solution(new int[] {-5, 5, -5, 4})+", 답:125");
        System.out.println(s.solution(new int[] {-5, -6, -4, -7, -10})+", 답:-120");
    }

    public int solution(int[] A) {
    	//-999000000 ~ 999000000 최댓값
    	int none_num = 1;
    	int max=-1000000000,compare=-1000000000, pos_cnt=0,neg_cnt=0;
    	int[] positive_max_num = new int[] {none_num,none_num,none_num};
    	int[] negative_min_num = new int[] {none_num,none_num,none_num};
    	int[] negative_max_num = new int[] {none_num,none_num,none_num};
    	
    	boolean hasZero = false;
		
    	for( int i=0; i<A.length; i++ ) {
    		int num = A[i];
    		if( num == 0 ) {
    			//0인 숫자 구분하기
    			hasZero = true;
    		} else if( num > 0 ) {
    			//양수 처리
    			for( int j=0; j<positive_max_num.length; j++ ) {
    				if( num >= positive_max_num[j] ) {
    					for( int k=positive_max_num.length-1; k>j; k--) {
    						positive_max_num[k] = positive_max_num[k-1];
    					}
    					positive_max_num[j] = num;
    					pos_cnt++;
    					break;
    				}
    			}
    		}else {
    			//음수 처리
			neg_cnt++;
    			
    			//음수 최솟값
    			for( int j=0; j<negative_min_num.length; j++ ) {
    				if( negative_min_num[j] == none_num ) {
    					negative_min_num[j] = num;
    					break;
    				}
    				if( num < negative_min_num[j] ) {
        				for( int k=negative_min_num.length-1; k>j; k--) {
        					negative_min_num[k] = negative_min_num[k-1];
        				}
        				negative_min_num[j] = num;
        				break;
    				}
    			}
    			
    			//음수 최댓값
    			for( int j=0; j<negative_max_num.length; j++ ) {
    				if( negative_max_num[j] == none_num ) {
    					negative_max_num[j] = num;
    					break;
    				}
    				if( num > negative_max_num[j] ) {
					for( int k=negative_max_num.length-1; k>j; k--) {
        					negative_max_num[k] = negative_max_num[k-1];
        				}
        				negative_max_num[j] = num;
        				break;
    				}
    			}
    		}
    	}
    	
    	if( pos_cnt >= 3 ) //양수가 3개이상 있는 경우
    		compare = positive_max_num[0]*positive_max_num[1]*positive_max_num[2];

    	if( max < compare )
    		max = compare;
    	
    	if( pos_cnt >= 1 && neg_cnt >= 2 ) //양수+음수 있는 경우
    		compare = positive_max_num[0]*negative_min_num[0]*negative_min_num[1];

    	if( max < compare )
    		max = compare;
    	
    	if( pos_cnt == 0 ) //음수만 있는 경우
    		compare = negative_max_num[0]*negative_max_num[1]*negative_max_num[2];

    	if( max < compare )
    		max = compare;
    	
    	if( hasZero && max < 0 ) //0이 있는 경우
    		max = 0;
    	
    	return max;
    }
}
