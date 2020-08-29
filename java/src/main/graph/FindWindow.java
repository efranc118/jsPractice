package main.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindWindow {

    boolean[][] visited;

    public ArrayList<Integer[]> findWindow(int[][] image) {

        int leftX = 0;
        int leftY = 0;
        int rightX = 0;
        int rightY = 0;
        visited = new boolean[image.length][image[0].length];
        ArrayList<Integer[]> result = new ArrayList<>();
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[0].length; j++) {
                if(image[i][j] == 0 && !visited[i][j]) {
                    leftX = j;
                    leftY = i;
                Integer[] bottomRight = findBottomRight(i, j, image, visited);
                rightY = bottomRight[0];
                rightX = bottomRight[1];
                result.add(new Integer[] {leftY, leftX, rightY, rightX});
                }
            }
        }
        return result;
    }


    public Integer[] findBottomRight(int row, int col, int[][] image, boolean[][] visited) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, col});
        Integer[] lastPos = new Integer[] {row, col};

        Integer[][] dx = new Integer[][] {{0, 1},{1,0}};
        while(!queue.isEmpty()) {
            lastPos = queue.remove();
            if(!visited[lastPos[0]][lastPos[1]]) {
                visited[lastPos[0]][lastPos[1]] = true;
                for (Integer[] d : dx) {
                    int nextX = d[0] + lastPos[0];
                    int nextY = d[1] + lastPos[1];
                    if (nextX < image.length && nextY < image[0].length && image[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        queue.add(new Integer[] {nextX, nextY});
                    }
                }
            }
        }
        return lastPos;
    }



    public static void main(String[] args) {
        FindWindow solution = new FindWindow();
        int[][] image =
                new int[][]
                {
                {0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0}
                };
        ArrayList<Integer[]> results = solution.findWindow(image);
        for(Integer[] result: results) {
            System.out.println(Arrays.toString(result));
        }
    }

}
