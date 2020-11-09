package main.dynamic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class OptimalPathSum {

//    static List<Integer> minList;
//    static Integer minVal = Integer.MAX_VALUE;

//    public Integer findMinSum(Integer[][] matrix, Integer curSum, Integer row, Integer col, List<Integer> list) {
////        curSum += matrix[row][col];
////        list.add(matrix[row][col]);
////        if(row == matrix.length  - 1 && col == matrix[0].length - 1) {
////            if(curSum < minVal) minList = list;
////            return curSum;
////        }
////        Integer rightSum = row < matrix.length - 1 ? findMinSum(matrix, curSum, row + 1, col, new ArrayList<>(list)) : null;
////        Integer downSum =  col < matrix[0].length - 1 ? findMinSum(matrix, curSum, row, col + 1, new ArrayList<>(list)): null;
////
////        if(rightSum == null) {
////            return downSum;
////        }
////        if(downSum == null) {
////            return rightSum;
////        }
////
////        Integer min = Math.min(rightSum, downSum);
////        return min;
////    }


    public Integer findMinSum(Integer[][] matrix) {
        int rowMax = matrix.length - 1;
        int colMax = matrix[0].length - 1;
        Integer[][] dp = new Integer[rowMax + 1][rowMax + 1];

        dp[rowMax][colMax] = matrix[rowMax][colMax];
        for(int i = rowMax - 1; i>=0; i--) {
            dp[i][rowMax] = matrix[i][rowMax] += dp[i + 1][rowMax];
            dp[rowMax][i] = matrix[rowMax][i] += dp[rowMax][i + 1];
        }

        for(int i = rowMax - 1; i >= 0; i--) {
            for(int j = rowMax - 1; j >=0; j--) {
                Integer min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        File file = new File("matrix.txt");

        Integer[][] matrix = new Integer[80][80];

        //Creating Scanner instnace to read File in Java
        Scanner scnr = null;
        try {
            scnr = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Reading each line of file using Scanner class
        int lineNumber = 0;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            String[] vals = line.split(",");
            int count = 0;
            for(String val: vals) {
                matrix[lineNumber][count++] = Integer.parseInt(val);
            }
            lineNumber++;
        }


        OptimalPathSum solution = new OptimalPathSum();
//        Integer[][] demo = new Integer[][] {{1,2,3,4}, {5,6,7,8},{9,10,11,12}, {13,14,15,16}};
        Integer[][] demo = new Integer[][] {{1,1,1,30}, {1,1,1,30},{1,1,1,30}, {30,30,30,30}};
        System.out.println(solution.findMinSum(demo));
    }

}
