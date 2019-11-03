package week_7.ruby;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kangaroo {
	
	// Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
    	//만날 수 없는 경우
    	if( v1 <= v2 ) return "NO";

    	int gap = x2 - x1;
    	int count = gap / v1 + ( gap % v1 == 0 ? 0 : 1 );
    	System.out.println("count = " + count);
    	int kangaroo1 = x1 + v1 * count;
    	int kangaroo2 = x2 + v2 * count;
    	while(kangaroo1 < kangaroo2) {
    		kangaroo1 += v1;
    		kangaroo2 += v2;
    		System.out.println("kangaroo1 => " + kangaroo1 + ", kangaroo2 => " + kangaroo2);
    	}
    	
    	return kangaroo1 == kangaroo2 ? "YES" : "NO";
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
