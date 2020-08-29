package main.graph;


import javafx.util.Pair;

import java.util.*;

public class ZombieMatrix {


    public int minHours(int rows, int cols, List<List<Integer>> grid) {

        Queue<Pair<Integer, Integer>> zombies = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i< rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid.get(i).get(j) == 1) zombies.add(new Pair<>(i,j));
                if(grid.get(i).get(j) == 0) cnt++;
            }
        }

        int hours = 0;

        //Hour delimiter
        zombies.add(new Pair<>(-1,-1));
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!zombies.isEmpty()) {
            Pair<Integer, Integer> zombie = zombies.remove();
            //We've hit the hour mark
            if(zombie.getKey() == -1) {
                hours++;
                if(cnt == 0) return hours;
                if(!zombies.isEmpty()) {
                    zombies.add(new Pair<>(-1,-1));
                }

            } else {
                for(int[] d: directions) {
                    int nextRow = zombie.getKey() + d[0];
                    int nextCol = zombie.getValue() + d[1];

                    if(nextRow >= 0 && nextRow < grid.size() &&
                    nextCol >= 0 && nextCol < grid.get(0).size() &&
                    grid.get(nextRow).get(nextCol) == 0) {
                        grid.get(nextRow).set(nextCol, 1);
                        cnt--;
                        zombies.add(new Pair<>(nextRow, nextCol));
                    }
                }
            }
        }

        return hours;

    }

    public static void main(String[] args) {
        ZombieMatrix solution = new ZombieMatrix();
        ArrayList<List<Integer>> zombieLand = new ArrayList<>();
        zombieLand.add(Arrays.asList(0,1,1,0,1));
        zombieLand.add(Arrays.asList(0,1,0,1,0));
        zombieLand.add(Arrays.asList(0,0,0,0,1));
        zombieLand.add(Arrays.asList(0,1,0,0,0));
        System.out.println(solution.minHours(4,5, zombieLand));
    }

}
