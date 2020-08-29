package main.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {

    public int knightDialer(int N) {
        return getCombinations(1,N);

    }


    public int getCombinations(int curValue, int remainingJumps) {

        if(remainingJumps == 0) return 1;

        int count = 0;

        Map<Integer, List<Integer>> neighbors = getAvailableJumps();

        List<Integer> curNeighbors = neighbors.get(curValue);
        for(int neighbor : curNeighbors) {
            count += getCombinations(neighbor, remainingJumps - 1);
        }

        return count;
    }




    public Map<Integer, List<Integer>> getAvailableJumps() {
        int[][] keypad = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        HashMap<Integer, List<Integer>> valueCount = new HashMap<>();

        int[][] directions = new int[][] {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1},{2, -1}, {2,1}};
        for(int i = 0; i < keypad.length; i++) {
            for(int j = 0; j < keypad[i].length; j++) {
                List<Integer> neighbors = new ArrayList<>();
                for(int[] direction : directions) {
                    int row = i + direction[0];
                    int col = j + direction[1];
                    if(row >= 0 && row < keypad.length && col >= 0 && col < keypad[i].length && keypad[row][col] != -1) neighbors.add(keypad[row][col]) ;
                }
                valueCount.put(keypad[i][j], neighbors);
            }
        }


    return valueCount;
    }


    public static void main(String[] args) {
        KnightDialer solution = new KnightDialer();
        System.out.println(solution.getCombinations(6,2));
    }

}
