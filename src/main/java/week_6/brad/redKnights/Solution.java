package week_6.brad.redKnights;

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

    static String result = "";
    static int count=0;

    static String printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        if (!isPossible(i_start, i_end)){
            return "impossible";
        }

        /*
            todo
              - endCondition 재정의
         */
        if(process(i_start, j_start, i_end, j_end)){
            return count + "\n" +result;
        }else{
            return "impossible";
        }
    }

    private void endCondition(int i_start, int j_start, int i_end, int j_end){
        if(i_start > i_end){
            // j_start < 0 종료
        }

        if(i_start < i_end){
            // i_start > i_end 종료
        }

        if(j_start > j_end){
            // j_start < 0 종료
        }

        if(j_start < j_end){
            // j_start > j_end 종료
        }
    }

    private static boolean process(int i_start, int j_start, int i_end, int j_end) {
        if(i_start < 0 || j_start < 0){
            result = "impossible";
            return false;
        }

        if(i_start == i_end && j_start == j_end){
            return true;
        }

        moveUpperLeft(i_start, j_start, i_end, j_end);
        moveUpperRight(i_start, j_start, i_end, j_end);
        moveRight(i_start, j_start, i_end, j_end);
        moveLowerRight(i_start, j_start, i_end, j_end);
        moveLowerLeft(i_start, j_start, i_end, j_end);
        moveLeft(i_start, j_start, i_end, j_end);

        return true;
    }

    private static void moveUpperLeft(int i_start, int j_start, int i_end, int j_end) {
        if(i_start > i_end && j_start >= j_end){
            i_start -= 2;
            j_start -= 1;

            count++;
            result += "UL ";

            process(i_start, j_start, i_end, j_end);
        }
    }

    private static void moveUpperRight(int i_start, int j_start, int i_end, int j_end) {
        if(i_start > i_end && j_start <= j_end){
            i_start += 2;
            j_start -= 1;


            count++;
            result += "UR ";
            process(i_start, j_start, i_end, j_end);
        }
    }

    private static void moveRight(int i_start, int j_start, int i_end, int j_end) {
        if(i_start == i_end && j_start < j_end){
            j_start += 2;

            count++;
            result += "R ";
            process(i_start, j_start, i_end, j_end);
        }
    }

    private static void moveLowerRight(int i_start, int j_start, int i_end, int j_end) {
        if(i_start < i_end && j_start <= j_end){
            i_start += 2;
            j_start += 1;

            count++;
            result += "LR ";
            process(i_start, j_start, i_end, j_end);
        }
    }

    private static void moveLowerLeft(int i_start, int j_start, int i_end, int j_end) {
        if(i_start < i_end && j_start >= j_end){
            i_start += 2;
            j_start -= 1;

            count++;
            result += "LL ";

            process(i_start, j_start, i_end, j_end);
        }
    }

    private static void moveLeft(int i_start, int j_start, int i_end, int j_end) {
        if(i_start == i_end && j_start > j_end){
            j_start -= 2;

            count++;
            result += "L ";

            process(i_start, j_start, i_end, j_end);
        }
    }


    private static boolean isPossible(int i_start, int i_end){
        return (i_start + i_end) % 2 == 0;
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
