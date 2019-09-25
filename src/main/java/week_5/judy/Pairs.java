package week_5.judy;

import java.util.Arrays;
import java.util.Scanner;

/**
You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.

For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: , , and .

Function Description

Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.

pairs has the following parameter(s):

k: an integer, the target difference
arr: an array of integers
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Output Format

An integer representing the number of pairs of integers whose difference is .

[Sample Input]
5 2  
1 5 3 4 2  

[Sample Output]
3

[Explanation]
There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1] .
 
source : https://www.hackerrank.com/challenges/pairs/problem
 */
public class Pairs {
	public int solution() {
		int n, k;
		int[] arr;
		
		Scanner sc = new Scanner(System.in);
		String scan1 = sc.nextLine();
		
		if( scan1 == null || "".equals(scan1) || ! scan1.contains(" ") ) {
			System.out.println("wrong format");
			sc.close();
			return 0;
		}
		
		n = Integer.parseInt(scan1.split(" ")[0]);
		k = Integer.parseInt(scan1.split(" ")[1]);
		arr = new int[n];
		
		String scan2 = sc.nextLine();
		
		if( scan2 == null || "".equals(scan2) || ! scan2.contains(" ") ) {
			System.out.println("wrong format");
			sc.close();
			return 0;
		}
		
		String[] s_arr = scan2.split(" ");
		for( int i=0; i<s_arr.length; i++ ) {
			arr[i] = Integer.parseInt(s_arr[i]);
		}
		
		sc.close();
		
		return distanceNumCount(arr,k);
	}
	
	public int distanceNumCount( int[] arr, int k ) {
		Arrays.sort( arr );
		
		int diff;
		int count=0;
		for( int i=0; i<arr.length; i++ ) {
			for( int j=i+1; j<arr.length; j++ ) {
				diff = arr[j]-arr[i];
				if( diff == k )
					count++;
				else if( diff > k )
					break;
			}
		}
		return count;
	}
}
