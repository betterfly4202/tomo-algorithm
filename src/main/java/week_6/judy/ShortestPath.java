package week_6.judy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * source : https://www.hackerrank.com/challenges/red-knights-shortest-path/problem
 */
public class ShortestPath {
	static char y_UPPER = 'U';
	static char y_LOWER = 'L';
	static char x_RIGHT = 'R';
	static char x_LEFT = 'L';
	
	static List<String> paths = new ArrayList<>();
	static List<String> footprint = new ArrayList<>();

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
    	Character x=null, y=null;
    	
    	footprint.add(String.format("%s,%s", i_start,j_start));

    	if( i_start < i_end ) {
    		y = y_LOWER;
    		i_start = i_start+2;
    	}
    	if( i_start > i_end ) {
    		y = y_UPPER;
    		i_start = i_start-2;
    	}
    	if( j_start <= j_end ) {
    		x = x_RIGHT;
    		j_start = j_start+(y==null?2:1);
    	}else if( j_start > j_end ) {
    		x = x_LEFT;
    		j_start = j_start-(y==null?2:1);
    	}
    	
    	if( isImpossible(n, i_start, j_start, x, y) ) {
    		System.out.println("Impossible");
    		return;
    	}
    	
    	String path = y == null ? String.valueOf(x) : String.valueOf(y)+String.valueOf(x);
    	
    	paths.add( path );

    	if( i_start == i_end && j_start == j_end ) {
        	sort();
    		printPath();
    		return;
    	}
    	
    	printShortestPath(n, i_start, j_start, i_end, j_end );
    }

	private static void sort() {
		Map<String, Integer> priority = new HashMap<String, Integer>();
		priority.put("UL", 6);
		priority.put("UR", 5);
		priority.put("R", 4);
		priority.put("LR", 3);
		priority.put("LL", 2);
		priority.put("L", 1);
		
		String[] paths_arr = new String[paths.size()];
		paths.toArray(paths_arr);
		
		for( int i=0; i<paths_arr.length-1; i++ ) {
			for( int j=1; j<paths_arr.length-i; j++ ) {
				if( priority.get(paths_arr[j-1]) < priority.get(paths_arr[j]) ) {
					String tmp = paths_arr[j];
					paths_arr[j]=paths_arr[j-1];
					paths_arr[j-1]=tmp;
				}
			}
		}
		
		paths = Arrays.asList( paths_arr );
	}

	private static void printPath() {
		System.out.println(paths.size());
		
		for( int i=0; i<paths.size(); i++ ) {
			System.out.print(paths.get(i));
			
			if( i != paths.size()-1 )
				System.out.print(" ");
		}
	}

	private static boolean isImpossible(int n, int i_start, int j_start, Character x, Character y) {
		if( x == null )
			return true;
		
		if( i_start < 0 || i_start > n-1 )
			return true;

		if( j_start < 0 || j_start > n-1 )
			return true;

    	if( footprint.contains(String.format("%s,%s", i_start,j_start)) )
    		return true;
    	
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}
