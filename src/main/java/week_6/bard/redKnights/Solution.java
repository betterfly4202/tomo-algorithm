package week_6.bard.redKnights;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by betterfly
 * Date : 2019.10.20
 */
public class Solution {

    enum Operation {
        UPPER_LEFT("UL") {
            int apply(int i_start, int j_start) {
                return i_start-1 + j_start-2;
            }
        },
        UPPER_RIGHT("UR") {
            int apply(int i_start, int j_start) {
                return i_start+1 + j_start-2;
            }
        },
        RIGHT("R") {
            int apply(int i_start, int j_start) {
                return i_start+2;
            }
        },
        LOWER_RIGHT("LR") {
            int apply(int i_start, int j_start) {
                return i_start+1 + j_start+2;
            }
        },
        LOWER_LEFT("LL") {
            int apply(int i_start, int j_start) {
                return i_start-1 + j_start+2;
            }
        },
        LEFT("L") {
            int apply(int i_start, int j_start) {
                return i_start-2 ;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        abstract int apply(int x, int y);
    }

    static Map<Integer, String> pathMap = new LinkedHashMap<>();

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        if(!isPossible(i_start, i_end)){
            String as="impossible";
        }

        process(i_start, j_start, i_end, j_end, 0);

        System.out.println(pathMap);
    }

    private static void process(int i_start, int j_start, int i_end, int j_end, int count) {
        if(i_start > i_end && j_start > j_end){
            i_start -= 1;
            j_start -= 2;

            pathMap.put(count++, "UL");

            process(i_start, j_start, i_end, j_end, count);
        }

        if(i_start > i_end && j_start < j_end){
            i_start += 1;
            j_start -= 2;

            pathMap.put(count++, "UR");
            process(i_start, j_start, i_end, j_end, count);
        }

        if(i_start == i_end && j_start < j_end){
            i_start += 2;

            pathMap.put(count++, "R");
            process(i_start, j_start, i_end, j_end, count);
        }

        if(i_start < i_end && j_start < j_end){
            i_start += 1;
            j_start += 2;

            pathMap.put(count++, "LR");
            process(i_start, j_start, i_end, j_end, count);
        }

        if(i_start > i_end && j_start < j_end){
            i_start -= 1;
            j_start += 2;

            pathMap.put(count++, "LL");
            process(i_start, j_start, i_end, j_end, count);
        }

        if(i_start == i_end && j_start > j_end){
            i_start -= 2;

            pathMap.put(count++, "L");
            process(i_start, j_start, i_end, j_end, count);
        }
    }

    private static boolean isPossible(int i_start, int i_end){
        return (i_start - i_end)/2 == 0;
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
