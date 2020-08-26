import java.util.LinkedList;
import java.util.Queue;

public class Islands {

        public int numIslands(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    visited[i][j] = false;
                }
            }

            int islandCount = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        if(grid[i][j] == '1') {
                            dfs(grid,visited,i, j);
                            islandCount++;
                        }
                    }
                }
            }
            return islandCount;
        }


        public void dfs(char[][] grid, boolean[][] visited, int row, int column) {
            visited[row][column] = true;
            if(grid[row][column] == '1') {
                if(row - 1 >= 0 && grid[row - 1][column] == '1' && !visited[row - 1][column]) {
                    dfs(grid,visited,row - 1, column);
                }
                if(column - 1 >= 0 && grid[row][column - 1] == '1' && !visited[row][column - 1]) {
                    dfs(grid, visited, row, column - 1);
                }
                if(row + 1 < grid.length && grid[row + 1][column] == '1' && !visited[row + 1][column]) {
                    dfs(grid, visited, row + 1, column);
                }
                if(column + 1 < grid[0].length && grid[row][column + 1] == '1' && !visited[row][column + 1]) {
                    dfs(grid, visited, row, column + 1);
                }
            }
        }

    public static void main(String[] args) {
        Islands solution = new Islands();
        char[][] islands = new char[4][5];
        islands[0] = new char[] {'1','1','0','0','0'};
        islands[1] = new char[] {'1','1','0','0','0'};
        islands[2] = new char[] {'0','0','1','0','0'};
        islands[3] = new char[] {'0','0','0','1','1'};
        System.out.println(solution.numIslands(islands));
    }

}
