package week_5.ruby;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GoodlandElectricity {

    // Complete the pylons function below.
    static int pylons(int k, int[] arr) {
    	int start = 0;
    	int boundary = k;
    	int maxBoundary = k * 2 - 1;
    	int eleccity = 0;
    	while( start < arr.length ) {
    		boolean built = false;
    		
    		//공장이 지어질 수 있는 가장 먼 거리 계산
    		for( int i=boundary-1; i>=0; i--) {
    			System.out.println("start " + start + ", check ->" + (start + i));

    			if( arr[start + i] == 0 ) continue;
    			
    			eleccity++;
    			start += i;
    			built = true;
    			System.out.println("start -> " + start);
    			break;
    		}
    		
    		if( ! built ) return -1;
    		
    		int remain = arr.length - start;
    		
    		//다음 범위 체크
    		if(remain > maxBoundary) {
    			boundary = maxBoundary;
    		} else {
    			if( remain - 1 < k ) return eleccity;
    			else boundary = remain -1;
    		}
    		
    		start++;
    	}
    	
    	return eleccity;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pylons(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
