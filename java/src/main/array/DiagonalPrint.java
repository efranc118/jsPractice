package main.array;


/**
 *    1   2  3  4
 *    5   6  7  8
 *    9  10 11 12
 *    13 14 15 16
 *    17 18 19 20
 *
 *
 */

public class DiagonalPrint {


    public void printMatrix(int[][] matrix) {


        for(int i = 0; i < matrix.length; i++) {
            printRow(matrix, i, 0);
        }

        for(int i = 1; i < matrix.length; i++) {
            printRow(matrix, matrix.length - 1, i);
        }
    }


    public void printRow(int[][] matrix, int row, int col) {
        while(row >= 0 && col < matrix[0].length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DiagonalPrint solution = new DiagonalPrint();
        solution.printMatrix(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},
                {13,14,15,16},{17,18,19,20}});
    }

}
