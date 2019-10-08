package week_5.judy;

/**
Goodland is a country with a number of evenly spaced cities along a line. The distance between adjacent cities is  unit. There is an energy infrastructure project planning meeting, and the government needs to know the fewest number of power plants needed to provide electricity to the entire list of cities. Determine that number. If it cannot be done, return .

You are given a list of city data. Cities that may contain a power plant have been labeled . Others not suitable for building a plant are labeled . Given a distribution range of , find the lowest number of plants that must be built such that all cities are served. The distribution range limits supply to cities where distance is less than k.

For example, you are given  and your city data is . Each city is  unit distance from its neighbors, and we'll use  based indexing. We see there are  cities suitable for power plants, cities  and . If we build a power plant at , it can serve  through  because those endpoints are at a distance of  and . To serve , we would need to be able to build a plant in city  or . Since none of those is suitable, we must return . It cannot be done using the current distribution constraint.

[Function Description]
Complete the pylons function in the editor below. It should return an integer that represents the minimum number of plants required or -1 if it is not possible.

pylons has the following parameter(s):

k: an integer that represents distribution range
arr: an array of integers that represent suitability as a building site

[Input Format]
The first line contains two space-separated integers  and , the number of cities in Goodland and the plants' range constant.
The second line contains  space-separated binary integers where each integer indicates suitability for building a plant.

[Constraints]
1<=k<=n<=10^5
Each arr[i] contains {0,1}.

[Subtask]
1 <= k <= n <= 1000 for 40% of the maximum score.
Output Format

Print a single integer denoting the minimum number of plants that must be built so that all of Goodland's cities have electricity. 
If this is not possible for the given value of k, print -1.

[Sample Input]
6 2
0 1 1 1 1 0

[Sample Output]
2

[Explanation]
Cities , , , and  are suitable for power plants. Each plant will have a range of . If we build in cities  cities,  and , then all cities will have electricity.

source : https://www.hackerrank.com/challenges/pylons/problem
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GoodlandElectricity {

    // Complete the pylons function below.
    public static int pylons(int k, int[] arr) {
    	int count = 0;
    	int end_of_electron = -1;
    	
    	int city = getNextPlant(-1, arr, k);
    	
    	if( city == -1 )
    		return -1;
    	
    	while( city < arr.length ) {
			end_of_electron = city+k-1;
			count++;
			
			if( end_of_electron >= arr.length-1 ) 
				break;
			
			city = getNextPlant(city, arr,k);
			
			if( city == -1 )
				return -1;
    	}
    	return count;
    }

    private static int getNextPlant(int cur_city, int[] arr, int k) {
    	int end_of_electron = cur_city+k-1;
    	
    	int next_plant = cur_city >= 0 ? end_of_electron+k : cur_city+k;
    	
    	for( ; next_plant>cur_city ; next_plant-- ) {
    		if( next_plant > arr.length-1 )
    			next_plant= arr.length-1;
    		
    		if( arr[next_plant] == 1 ) {
    			return next_plant;
    		}
    	}
    	
		return -1;
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
