package main.graph;

import java.util.*;

public class CriticalConnections2 {

    //Super Nieve solution where we remove connections 1 by 1 and do a BFS expecting to find everything
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> results = new ArrayList<>();
        int ignore = 0;
        while(ignore < connections.size()) {
            List<List<Integer>> remainingConnections = new ArrayList<>();
            for(int i = 0; i < connections.size(); i++) {
                if(i != ignore) remainingConnections.add(connections.get(i));
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < remainingConnections.size(); i++) {
                int key, value;
                key = remainingConnections.get(i).get(0);
                value = remainingConnections.get(i).get(1);
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                if(!map.containsKey(value)) map.put(value, new ArrayList<>());
                map.get(key).add(value);
                map.get(value).add(key);
            }
            if(isCriticalConnection(n, map)) results.add(connections.get(ignore));
            ignore++;
        }

        return results;
    }




    public boolean isCriticalConnection(int n, Map<Integer, List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            Integer current = queue.remove();
            visited[current] = true;
            for(Integer neighbor : connections.get(current)) {
                if (!visited[neighbor]) queue.add(neighbor);
            }
        }
        for(int i = 0; i < visited.length; i++) if(!visited[i]) return true;
        return false;
    }

    public static void main(String[] args) {
        CriticalConnections2 solution = new CriticalConnections2();
        System.out.println(solution.criticalConnections(6, Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2),
                Arrays.asList(2,0), Arrays.asList(1,3), Arrays.asList(3,4), Arrays.asList(4,5), Arrays.asList(5,3))));
    }

}
