package week_7.brad.connectedCells;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by betterfly
 * Date : 2019.10.24
 */
public class Solution {
    static int connectedCell(int[][] matrix) {
        int maxSize = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int column = 0 ; column < matrix[row].length; column++){
                maxSize = getMaxSize(matrix, maxSize, row, column);
            }
        }

        return maxSize;
    }

    private static int getMaxSize(int[][] matrix, int maxSize, int row, int column) {
        if(matrix[row][column] != 1){
            return maxSize;
        }

        return Math.max(getRegionSize(matrix, row, column), maxSize);
    }

    private static int getRegionSize(int[][] matrix, int row, int column) {
        if (!validationRegion(matrix, row, column)){
            return 0;
        }

        matrix[row][column] = 0;
        int size = 1;

        for(int r = row-1; r <= row+1; r++){
            for(int c = column-1; c <= column+1; c++){
                if(r != row || c != column){
                    size += getRegionSize(matrix, r, c);
                }
            }
        }
        return size;
    }

    private static boolean validationRegion(int[][] matrix, int row, int column) {
        // row-1, col -1 < 0
        if(row < 0 || column < 0){
            return false;
        }

        if( row >= matrix.length || column >= matrix[row].length){
            return false;
        }

        if(matrix[row][column] == 0){
            return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}
