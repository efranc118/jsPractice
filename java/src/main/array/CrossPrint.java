package main.array;

import java.util.Arrays;

public class CrossPrint {

    int[] result;
    int pos;
    public int[] findDiagonalOrder(int[][] matrix) {
        result = new int[matrix.length * matrix[0].length];
        boolean upDir = true;

        for(int i = 0; i < matrix.length; i++) {
            addRow(matrix, i, 0, upDir);
            upDir = !upDir;
        }

        int start = matrix.length / matrix[0].length;
        for(int i = start; i < matrix.length; i++) {
            addRow(matrix, matrix.length - start, i, upDir);
            upDir = !upDir;
        }

        return result;
    }

    public void addRow(int[][] matrix, int row, int col, boolean upDir) {

        if(!upDir) {
            int temp = col;
            col = row;
            row = temp;
        }
        while(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            result[pos] = matrix[row][col];
            pos++;
            if(upDir){
                row--;
                col++;
            } else {
                row++;
                col--;
            }
        }
    }


    public static void main(String[] args) {
        CrossPrint solution = new CrossPrint();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{2,3}})));
    }

}
