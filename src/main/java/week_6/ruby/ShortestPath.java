package week_6.ruby;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Point implements Comparable<Point>{
	String type;
	int i;
	int j;
	int priority;
	
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public Point(String type, int i, int j, int priority) {
		this.type = type;
		this.i = i;
		this.j = j;
		this.priority = priority;
	}
	
	@Override
	public boolean equals(Object point) {
		return this.i == ((Point) point).i && this.j == ((Point) point).j;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("i=>").append(this.i).append(", j=>").append(this.j).toString();
	}

	@Override
	public int compareTo(Point o) {
		return this.priority - o.priority;
	}
}

public class ShortestPath {
	
	private static List<Point> route = new ArrayList<Point>();
	private static List<Point> path = new ArrayList<Point>();
	
	static {
		//우선순위
		route.add(new Point("UL", -2, -1, 1));
		route.add(new Point("UR", -2, 1, 2));
		route.add(new Point("R", 0, 2, 3));
		route.add(new Point("LR", 2, 1, 4));
		route.add(new Point("LL", 2, -1, 5));
		route.add(new Point("L", 0, -2, 6));
	}
	
	private static double getLength(int si, int sj, int ei, int ej) {
		return Math.sqrt((Math.pow((si - ei) * 1.0, 2.0) + Math.pow(( sj - ej)*1.0, 2.0 )));
	}
	
	static boolean calculatePath(Point start, Point end) {
		Iterator<Point> it = route.iterator();
		double length = getLength(start.i, start.j, end.i, end.j);
		Point tmp = null;
		//System.out.println("[start] " + start + " [end] " + end);
		while(it.hasNext()) {
			Point point = it.next();
			int tmpi = start.i + point.i;
			int tmpj = start.j + point.j;
			double tmpLength = getLength(tmpi, tmpj, end.i, end.j);
			//System.out.println("[" + point.type + "]" + tmpi + "," + tmpj + " length => " + length + ", tmp => " + tmpLength);
			if( tmpLength < length ) {
				length = tmpLength;
				tmp = point;
			}
		}
		
		if(tmp == null) return false;
		
		start.i = start.i + tmp.i;
		start.j = start.j + tmp.j;
		path.add(tmp);
		//System.out.println(path);
		return true;
	}
	
	static boolean checkBoundary(int n, Point start) {
		return (start.i >= 0 && start.j >= 0) && ( start.i < n && start.j < n );
	}
	
	// Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Print the distance along with the sequence of moves.
    	Point start = new Point(i_start, j_start);
    	Point end = new Point(i_end, j_end);
    	boolean show = true;
    	while(  ! start.equals(end) ) {   	
    		//System.out.println(start);
    		if( ! ( checkBoundary(n, start) && calculatePath(start, end) ) ) {
    			System.out.print("Impossible");
    			show = false;
    			break;
    		}
    	}
    	
    	Collections.sort(path);
    	
    	if( show ) {
    		System.out.println(path.size());
    		for(int i=0; i<path.size(); i++) {
    			System.out.print(path.get(i).type);
    			if( i < path.size() - 1 )
    				System.out.print(" ");
    		}
    	}
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
