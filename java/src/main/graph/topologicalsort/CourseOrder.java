package main.graph.topologicalsort;

import java.util.*;

public class CourseOrder {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] indices = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            List<Integer> neighbors = g.getOrDefault(prerequisites[i][1], new ArrayList<>());
            neighbors.add(prerequisites[i][0]);
            indices[prerequisites[i][0]]++;
            g.put(prerequisites[i][1], neighbors);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indices.length; i++) {
            if(indices[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            Integer curCourse = q.remove();
            count++;
            List<Integer> neighbors = g.get(curCourse);
            if(neighbors != null) {
                for(Integer neighbor: neighbors) {
                    indices[neighbor]--;
                    if(indices[neighbor] == 0) q.add(neighbor);
                }
            }
        }

        return count == numCourses;
    }



    public static void main(String[] args) {
        CourseOrder solution = new CourseOrder();
        System.out.println(solution.canFinish(2, new int[][]{{1,0}}));
    }

}
