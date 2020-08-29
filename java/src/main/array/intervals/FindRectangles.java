package main.array.intervals;

import java.util.ArrayList;
import java.util.List;

public class FindRectangles {


    public List<List<Integer[]>> findRectangles(int[][] grid) {

        List<List<Integer[]>> ans = new ArrayList<>();
        if(grid == null || grid.length == 0 || grid[0].length == 0) return ans;


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    findRectangle(grid, i, j, ans);
                }
            }
        }
        return ans;
    }

    public void findRectangle(int[][] grid, int row, int col, List<List<Integer[]>> ans) {

        int maxRow = grid.length - 1;
        int maxCol = grid[0].length - 1;
        mainLoop:
        for (int i = row; i <= maxRow; i++) {
            for (int j = col; j <= maxCol; j++) {
                if (grid[i][j] == 0) {
                    //this is a possible end of the rectangle. add it to the ans

                    List<Integer[]> subAns = new ArrayList<>();

                    Integer[] startRectangle = new Integer[] {row, col};

                    subAns.add(startRectangle);

                    Integer[] endRectangle = new Integer[] {row, col};
                    subAns.add(endRectangle);

                    ans.add(subAns);
                } else {
                    maxCol = j - 1;
                    if (maxCol == col - 1) {
                        break mainLoop;
                    }
                    break;
                }
            }
        }
    }



    public static void main(String[] args) {
        FindRectangles solution = new FindRectangles();
        int[][] input = new int[][]{{1, 1, 1}, {1, 0, 1}};
        System.out.println(solution.findRectangles(input));
    }

}
