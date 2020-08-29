package main.graph;

import java.util.*;

/*
 *There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 * If it is impossible, return -1.
 */

public class NetworkDelay {

    private HashMap<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < times.length; i++) {
            int[] newConnection = times[i];
            if(!graph.containsKey(newConnection[0]))
                graph.put(newConnection[0], new ArrayList<>());
            List<int[]> connections = graph.get(newConnection[0]);
            connections.add(new int[] {newConnection[1], newConnection[2]});
        }

        for (int node: graph.keySet()) {
            graph.get(node).sort(Comparator.comparingInt(a -> a[1]));
        }

        dist = new HashMap();
        for(int i = 1; i <= N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(graph, K);
        int maxVal = 0;
        for(Integer val: dist.values()) {
            if(val == Integer.MAX_VALUE) return -1;
            maxVal = Math.max(val, maxVal);
        }
        return maxVal;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int start) {

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{start, 0});


        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            if (cur[1] >= dist.get(cur[0])) continue;
            dist.put(cur[0], cur[1]);
            List<int[]> connections = graph.get(cur[0]);
            if (connections != null) {
                for (int[] connection : connections) {
                    stack.push(new int[]{connection[0], cur[1] + connection[1]});
                }
            }
        }
    }


        public static void main(String[] args) {
        NetworkDelay solution = new NetworkDelay();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(solution.networkDelayTime(times, 4, 2));
    }

}
