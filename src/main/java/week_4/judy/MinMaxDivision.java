package week_4.judy;

import java.util.Arrays;

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

public class MinMaxDivision {

	//0점으로 다시 풀어야함.
	public int boards( int[] A, int k ) {
		int premax=-1, max=-1;
		int[] mid = getMidArr( A, k );
		int[] div = new int[k];
		div = sumDiv( div, A, mid );
		max = getMax( div );
		
		while( true ) {
			mid = move( div, mid );
			div = sumDiv( div, A, mid );
			max = getMax( div );
			
			if( premax != -1 && premax <= max ) {
				return premax;
			}
			
			premax = max;
		}
	}

	private int[] move(int[] div, int[] mid) {
		for( int i=0; i<div.length-1; i++ ) {
			if( div[i] == div[i+1] )
				continue;
			
			if( div[i] > div[i+1] ) {
				mid[i]++;
			}else {
				mid[i]--;
			}
			//System.out.print(" mid["+i+"]="+div[i]);
		}
		//System.out.println();
		return mid;
	}

	private int getMax(int[] div) {
		Arrays.sort( div );
		return div[div.length-1];
	}

	private int[] sumDiv(int[] div, int[] a, int[] mid) {
		int begin, end;
		for( int i=0; i<div.length; i++ ) {
			if( i==0 )
				begin = 0;
			else 
				begin = mid[i-1]+1;
			
			if( i==div.length-1 )
				end = a.length-1;
			else
				end = mid[i];
			
			div[i] = sum( a, begin, end );
			//System.out.print(" div["+i+"]="+div[i]);
		}
		//System.out.println();
		return div;
	}

	private int[] getMidArr(int[] a, int k) {
		int gap = a.length/k;
		int[] arr = new int[k-1];
		
		for( int i=0; i<arr.length; i++ ) {
			arr[i] = (i+1)*gap;
			//System.out.print(" mid["+i+"]="+arr[i]);
		}
		//System.out.println();
		return arr;
	}

	private int sum(int[] a, int start, int end) {
		int sum=0;
		for( int i=start; i<=end; i++ ) {
			sum += a[i];
		}
		return sum;
	}

}
