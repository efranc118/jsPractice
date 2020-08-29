package main.graph.topologicalsort;

import java.util.*;

public class CourseOrdering {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indices = new int[numCourses];
        for(int[] arr: prerequisites) {
            if(graph.containsKey(arr[1]))  graph.get(arr[1]).add(arr[0]);
            else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(arr[0]);
                graph.put(arr[1], newList);
            }
            indices[arr[0]]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        int dependencyCount = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indices[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            dependencyCount++;
            if(!graph.containsKey(node)) continue;
            for(Integer neighbor: graph.get(node)) {
                indices[neighbor]--;
                if(indices[neighbor] == 0) queue.add(neighbor);
            }
        }
        return dependencyCount == numCourses;
    }


    public static void main(String[] args) {
        CourseOrdering solution = new CourseOrdering();
        System.out.println(solution.canFinish(4, new int[][] {{1,0},{2,1}, {3,1}, {3,2}}));
    }

}
