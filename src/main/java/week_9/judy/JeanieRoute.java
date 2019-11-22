import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Permutation {
    private int n; 
    private int r;
    private ArrayList<Integer> orgList;
    private int[] res;
    private ArrayList<int[]> permList;
    
    public Permutation(int[] arr, int r){
        this.r = r;          
        this.n = arr.length; 
        this.res = new int[r]; 
        
        orgList = new ArrayList<Integer>();
        for(int item : arr)
            orgList.add(item);
    }
    
    public List<int[]> list(){
        permList = new ArrayList<>();
        
        perm(orgList, 0);
        
        return permList;
    }
 
    public void perm(ArrayList<Integer> itemList, int depth) {
        
        if (depth == r) {
        	permList.add(res.clone());
        }
        
        for (int i = 0; i < n-depth; i++){
            res[depth] = itemList.remove(i); 
            perm(itemList, depth+1);         
            itemList.add(i, res[depth]);    
        }
    }

}
public class JeanieRoute {

    private static int INF = Integer.MAX_VALUE;
    private static int max_citynum;
    /*
     * Complete the jeanisRoute function below.
     */
    static int jeanisRoute(int[] city, int[][] roads) {
    	int[][] dist = initializeDistanceArr( roads );
    	Permutation permutation = new Permutation(city, city.length);
    	List<int[]> p = permutation.list();
    	
    	int shortestpath = Integer.MAX_VALUE;
    	for( int[] perm : p ) {
    		int newpath=0;
    		for( int i=0; i< perm.length-1; i++ ) {
        		int src = perm[i];
        		int dest = perm[i+1];
    			int distance = djikstra(dist, max_citynum, src, dest);
    			newpath += distance;
    		}
    		if( newpath < shortestpath )
    			shortestpath = newpath;
    	}
    	return shortestpath;
    }

    private static class Node implements Comparable<Node> {
		int idx;
		int val;

		int getIdx() {
			return idx;
		}

		int getVal() {
			return val;
		}

		Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.getVal() - o.getVal();
		}
	}

    private static int djikstra(int[][] dist, int n, int src, int dest) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (src != i && dist[src][i] < INF) {
				priorityQueue.offer(new Node(i, dist[src][i]));
			}
		}
		while (!priorityQueue.isEmpty()) {
			Node next = priorityQueue.poll();
			int nidx = next.getIdx();
			int ndist = next.getVal();
			for (int i = 1; i <= n; i++) {
				if (dist[nidx][i] != INF && ndist + dist[nidx][i] < dist[src][i]) {
					dist[src][i] = ndist + dist[nidx][i];
					priorityQueue.offer(new Node(i, dist[src][i]));
				}
			}
		}
		return dist[src][dest];
    }

    private static int[][] initializeDistanceArr(int[][] roads) {
    	max_citynum = getMaxCitynum(roads);
    	
		int[][] dist = new int[max_citynum+1][max_citynum+1];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], INF);
		}
		for (int i = 0; i < roads.length; i++) {
			int a = roads[i][0];
			int b = roads[i][1];
			int d = roads[i][2];
			dist[a][b] = Math.min(dist[a][b], d);
			dist[b][a] = Math.min(dist[b][a], d);
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
