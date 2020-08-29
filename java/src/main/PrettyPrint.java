package main;

import java.util.ArrayList;

public class PrettyPrint {


    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < A * 2 - 1; i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < A * 2 - 1; j++) {
                result.get(i).add(0);
            }
        }

        int dir = 0;
        int value = A;
        int maxCol = A * 2 - 2;
        int maxRow = A * 2 - 2;
        int minRow = 0;
        int minCol = 0;
        int col = 0;
        int row = 0;
        while(minCol <= maxCol && minRow <= maxRow) {
            result.get(row).set(col, value);
            if(dir == 0) {
                if(col >= maxCol) {
                    dir = 1;
                    row++;
                    minRow++;
                }
                else col++;
            }
            else if(dir == 1) {
                if(row >= maxRow) {
                    dir = 2;
                    col--;
                    maxCol--;
                }
                else row++;
            }
            else if(dir == 2) {
                if(col <= minCol) {
                    dir = 3;
                    row--;
                    maxRow--;
                }
                else col--;
            }
            else if(dir == 3) {
                if(row <= minRow) {
                    dir = 0;
                    col++;
                    value--;
                    minCol++;
                }
                else row--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PrettyPrint solution = new PrettyPrint();
        System.out.println(solution.prettyPrint(4));
    }

}
