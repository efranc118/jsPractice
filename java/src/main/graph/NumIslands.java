package main.graph;

public class NumIslands {

        public int numIslands(char[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int islandCount = 0;

            for(int i = 0; i < grid.length; i++) {
                for(int j =0; j < grid[0].length; j++) {
                    if(!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        islandCount++;
                        dfs(grid, visited, new int[]{i,j});
                    }
                }
            }
            return islandCount;

        }

        public void dfs(char[][] grid, boolean[][] visited, int[] start) {
            visited[start[0]][start[1]] = true;
            int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
            for(int[] d: directions) {
                int nextRow = start[0] + d[0];
                int nextCol = start[1] + d[1];
                if(nextRow >= 0 && nextRow < grid.length && nextCol >=0 && nextCol < grid[0].length && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) dfs(grid, visited, new int[]{nextRow, nextCol});
            }
        }


    public static void main(String[] args) {
        NumIslands solution = new NumIslands();

        System.out.println(solution.numIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1',
                '0','0','0'}, {'0','0','0','0','0'}}));
    }

}
