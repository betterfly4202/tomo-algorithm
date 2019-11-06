package week_7.judy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

class Node{
	int x;
	int y;
	
	Node( int x, int y ){
		this.x = x;
		this.y = y;
	}
}
public class ConnectedCells {
	static int[][] graph;
	static boolean[][] visited;
	static Stack<Node> stack = new Stack<Node>();
	
    static int connectedCell(int[][] matrix) {
    	graph = matrix;
		visited = new boolean[graph.length][graph[0].length];
		for( int i=0; i<graph.length; i++ ) {
			Arrays.fill(visited[i], false);
		}
		
		int count = 0;
    	for( int i=0; i<matrix.length; i++ ) {
    		for( int j=0; j<matrix[i].length; j++ ) {
    			//System.out.print(graph[i][j]+" ");
    			if( isVisitableNode(i,j) ) {
    				int newcount = dfs( new Node(i,j) );
    				
    				if( count < newcount )
    					count = newcount;
    			}
    		}
    		System.out.println();
    	}
    	return count;
    }
	
	public static int dfs( Node node ) {
		int count = 0;
		
		stack.push(node);
		while( ! stack.isEmpty() ) {
			Node n = stack.pop();
			
			if( ! visited[n.x][n.y] ) {
				count++;
				
				visited[n.x][n.y] = true;

				//top
				checkRangeAndPushNode( n.x , n.y-1 );
				//bottom
				checkRangeAndPushNode( n.x , n.y+1 );
				//left
				checkRangeAndPushNode( n.x-1 , n.y );
				//right
				checkRangeAndPushNode( n.x+1 , n.y );
				//left top
				checkRangeAndPushNode( n.x-1 , n.y-1 );
				//right bottom
				checkRangeAndPushNode( n.x+1 , n.y+1 );
				//left bottom
				checkRangeAndPushNode( n.x-1 , n.y+1 );
				//right top
				checkRangeAndPushNode( n.x+1 , n.y-1 );
			}
		}
		return count;
	}

	private static void checkRangeAndPushNode(int x, int y) {
		if( isVisitableNode(x, y)) 
			stack.push(new Node(x, y));
	}
	
	private static boolean isVisitableNode(int x, int y) {
		if( x < 0 || x > graph.length-1 )
			return false;
		if( y < 0 || y > graph[0].length-1 )
			return false;

		if( graph[x][y] != 1 || visited[x][y] ) 
			return false;
		
		return true;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
