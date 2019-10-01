package week_4.judy;

/**
 You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

Write a function:

class Solution { public int solution(int K, int M, int[] A); }

that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

For example, given K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  
  A[2] = 5
  A[3] = 1
 
  A[4] = 2
  A[5] = 2
  A[6] = 2
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and K are integers within the range [1..100,000];
M is an integer within the range [0..10,000];
each element of array A is an integer within the range [0..M].
source : https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 */

public class MinMaxDivision2 {

	public static void main(String[] args) {
		MinMaxDivision2 s = new MinMaxDivision2();
		System.out.println( s.solution(3,1,new int[] {1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1}) );
	}

	// param  : 
	//     K = block의 갯수
	//     M = A배열안의 Integer의 최댓값
	//     A = 배열
	// return : board의 크기 (k개의 board로 구멍을 가릴 수 있는 최소 크기)
	
	public int solution(int K, int M, int[] A) { 
		int beg = max(A); //결과값 범위의 최소값 
		int end = sum(A); //결과값 범위의 최댓값 
		int result = -1;
		int mid=-1;

		while( beg <= end ) {
			mid = (beg+end)/2; 

			if( getBlockCount(A,mid) <= K ) { 
				end = mid - 1;
				result = mid;
			}else {
				beg = mid + 1;
			}
		}
		return result;
	}
	
	private int max(int[] A) {
		int max = -1;
		for( int num : A ) {
			if( num > max )
				max = num;
		}
		return max;
	}

	private int sum(int[] a) {
		int sum = 0;
		for( int num : a ) {
			sum += num;
		}
		return sum;
	}

	private int getBlockCount(int[] A, int sum_min) {
		int n= A.length;
		int block_count = 0;
		int last_sum = 0;
		
		for( int i=0; i<n; i++ ) {
			if( last_sum + A[i] > sum_min ) {
				last_sum = 0;
				block_count++;
			}
			
			last_sum += A[i];
			
			if( i==n-1 )
				block_count ++;

		}
		return block_count;
	}
	
}
