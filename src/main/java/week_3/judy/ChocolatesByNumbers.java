package week_3.judy;

import java.util.Arrays;

/**
Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

class Solution { public int solution(int N, int M); }

that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..1,000,000,000].

 source : https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
 */
public class ChocolatesByNumbers {
	public static void main(String[] args) {
		ChocolatesByNumbers s = new ChocolatesByNumbers();
		System.out.println( s.solution(947853, 4453) );
	}
	//test coverage : 100%
	public int solution(int N, int M) {
		//0에서 출발해서 N값만큼 돌다 다시 만나야 하므로
		//N과 M의 최소공배수에서 M값을 나눈값일 때 최초로 다시 만나게 된다.
		//N=최대공약수*X1, M=최대공약수*X2
		//최소공배수 = 최대공약수*X1*X2,
		//최소공배수/M = (최대공약수*X1*X2)/(최대공약수*X2) = X1 => count
		int gcd = gcd_using_divding(N, M);
		return N/gcd;
	}

	//O(N + M), correct : 100%, performence : 20%
	private int eatChocolate1( int[] chocolates , int pos, int N , int M ) {
		if( chocolates[pos] == 1 ) {
			chocolates[pos] = 0;
			return eatChocolate1(chocolates, (pos+M)%N , N,  M) + 1;
		}else {
			return 0;
		}
	}
	
	public int gcd_using_divding( int a, int b ) {
		if( a % b == 0 )
			return b;
		else
			return gcd_using_divding( b , a % b);
	}
}
