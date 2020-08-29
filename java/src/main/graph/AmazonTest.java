package main.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AmazonTest {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
    {
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];

        int storeCount = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < column; j++) {
                if(grid.get(i).get(j) == 1 && !visited[i][j]) {
                    storeCount++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return storeCount;
    }



    public void dfs(List<List<Integer>> grid, boolean[][] visited, int row, int col) {
        Stack<int[]> positions = new Stack<>();
        positions.push(new int[] {row, col});


        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!positions.isEmpty()) {
            int[] curPos = positions.pop();
            visited[curPos[0]][curPos[1]] = true;
            for(int[] d: directions) {
                int nextRow = d[0] + curPos[0];
                int nextCol = d[1] + curPos[1];
                if(nextRow >= 0 && nextRow < grid.size() &&
                nextCol >= 0 && nextCol < grid.get(0).size() &&
                !visited[nextRow][nextCol] && grid.get(nextRow).get(nextCol) == 1) positions.push(new int[] {nextRow,
                nextCol});
            }
        }

    }


    public static void main(String[] args) {
        AmazonTest solution = new AmazonTest();
        ArrayList<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1,1,0,0));
        grid.add(Arrays.asList(0,0,1,0));
        grid.add(Arrays.asList(0,0,0,0));
        grid.add(Arrays.asList(1,0,1,1));
        grid.add(Arrays.asList(1,1,1,1));
        System.out.println(solution.numberAmazonGoStores(5, 4, grid));
    }

}
