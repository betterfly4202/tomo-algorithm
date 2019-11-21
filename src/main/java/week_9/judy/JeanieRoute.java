package week_9.judy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class JeanieRoute {
	private static int INF = Integer.MAX_VALUE;
    /*
     * Complete the jeanisRoute function below.
     */
    static int jeanisRoute(int[] city, int[][] roads) {
    	int[][] dist = initializeDistanceArr( roads );
    	
        /*
         * Write your code here.
         */
    	return 0;
    }

    private static int[][] initializeDistanceArr(int[][] roads) {
    	int find_max_citynum = getMaxCitynum(roads);
    	
		int[][] dist = new int[find_max_citynum][find_max_citynum];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], INF);
		}
		for (int i = 0; i < roads.length; i++) {
			int a = roads[i][0]-1;
			int b = roads[i][1]-1;
			int d = roads[i][2];
			dist[a][b] = Math.min(dist[a][b], d);
		}

    	for( int[] d : dist ) {
        	System.out.println("dist="+Arrays.toString(d));
    	}
    	return dist;
	}

	private static int getMaxCitynum(int[][] roads) {
    	int max = 0;
    	
    	for( int[] road : roads ) {
    		if( max < road[0] )
    			max = road[0];
    		
    		if( max < road[1] )
    			max = road[1];
    	}
    	return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] city = new int[k];

        String[] cityItems = scanner.nextLine().split(" ");

        for (int cityItr = 0; cityItr < k; cityItr++) {
            int cityItem = Integer.parseInt(cityItems[cityItr].trim());
            city[cityItr] = cityItem;
        }

        int[][] roads = new int[n-1][3];

        for (int roadsRowItr = 0; roadsRowItr < n-1; roadsRowItr++) {
            String[] roadsRowItems = scanner.nextLine().split(" ");

            for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
                int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
                roads[roadsRowItr][roadsColumnItr] = roadsItem;
            }
        }

        int result = jeanisRoute(city, roads);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
