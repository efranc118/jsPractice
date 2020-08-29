package main;

import java.util.Arrays;

public class MatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i = 0; i < rows.length; i++) {
            if(rows[i] == 1) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < cols.length; i++) {
            if(cols[i] == 1) {
                for(int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixZeroes solution = new MatrixZeroes();
        int[] row1 = new int [] {0,1,2,0};
        int[] row2 = new int [] {3,4,5,2};
        int[] row3 = new int [] {1,3,1,5};
        int[][] matrix = new int[][] {row1, row2, row3};
        solution.setZeroes(matrix);

    }

}
