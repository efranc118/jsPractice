package main.graph;

public class RottingOranges {


    public int orangesRotting(int[][] grid) {

        int count = 0;

        int[] dx = new int[] {-1,0,0,1};
        int[] dy = new int[] {0,-1,1,0};
        int missCount = 0;
        while(!isFinished(grid)) {
            int[][] nextGrid = new int[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == 2) nextGrid[i][j] = 2;
                    else if(grid[i][j] == 1) {
                        for(int k = 0; k < dx.length; k++) {
                            if(i + dx[k] >= 0 && i + dx[k] < grid.length &&
                                    j + dy[k] >= 0 && j + dy[k] < grid[i].length) {
                                if(grid[i + dx[k]][j + dy[k]] == 2) nextGrid[i][j] = 2;
                                if(grid[i + dx[k]][j + dy[k]] == 0) missCount++;
                            } else missCount++;
                        }
                        if(missCount == 4) return -1;
                        missCount = 0;
                        if(nextGrid[i][j] != 2) nextGrid[i][j] = 1;
                    }
                    else nextGrid[i][j] = 0;
                }
            }
            grid = nextGrid;
            count++;
        }
        return count;
    }

    public boolean isFinished(int[][] grid) {
        int rottenCount, healthyCount;
        rottenCount = healthyCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) healthyCount++;
                if(grid[i][j] == 2) rottenCount++;
            }
        }
        if(rottenCount == 0 || healthyCount == 0) return true;
        return false;
    }




    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        System.out.println(solution.orangesRotting(new int[][] { {2,1,1},{1,1,0},{0,1,1} } ));
    }

}
