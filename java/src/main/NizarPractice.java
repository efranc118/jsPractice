package main;

import java.util.*;

public class NizarPractice {


    // return all individuals who have 0 parents {1,2,14,13},
    // return all individual who have exactly 1 parent {4,5, 7,8,12,11}
    public List<List<Integer>> findRootsAndSingleParents(int[][] parentChildPairs) {

        Map<Integer, List<Integer> > graph = new HashMap<>();

            for(int[] edge: parentChildPairs) {
            List<Integer> parents = graph.getOrDefault(edge[1], new ArrayList<>());
            parents.add(edge[0]);
            graph.put(edge[1], parents);
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
        }

        List<List<Integer>> result = new ArrayList<>();
            List<Integer> rootNodes = new ArrayList<>();
            List<Integer> singleParent = new ArrayList<>();
        for(Integer child : graph.keySet()) {
            List<Integer> parents = graph.get(child);
            if(parents.size() == 0) rootNodes.add(child);
            if(parents.size() == 1) singleParent.add(child);
        }
        result.add(rootNodes);
        result.add(singleParent);
        return result;
    }

    public Boolean hasCommonAncestor(int[][] parentChildPairs, Integer member1, Integer member2) {

        Map<Integer, List<Integer> > graph = new HashMap<>();

        for(int[] edge: parentChildPairs) {
            List<Integer> parents = graph.getOrDefault(edge[1], new ArrayList<>());
            parents.add(edge[0]);
            graph.put(edge[1], parents);
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
        }

        Set<Integer> ancestors = getAncestors(graph, member1);
        Set<Integer> ancestors2 = getAncestors(graph, member2);

        for(Integer ancestor: ancestors) {
            if(ancestors2.contains(ancestor)) return true;
        }
        return false;
    }


    public Set<Integer> getAncestors(Map<Integer, List<Integer>> graph, Integer start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        Set<Integer> result= new HashSet<>();

        while(!queue.isEmpty()) {
            Integer cur = queue.remove();
            result.add(cur);
            List<Integer> parents = graph.get(cur);
            for(Integer parent: parents) {
                queue.add(parent);
            }
        }
        return result;

    }



    public static void main(String[] args) {
        NizarPractice solution = new NizarPractice();
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4,5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };
        List<List<Integer>> results = solution.findRootsAndSingleParents(parentChildPairs1);
        System.out.println(solution.hasCommonAncestor(parentChildPairs1, 6,7));
        System.out.println(solution.hasCommonAncestor(parentChildPairs1, 12,3));
        System.out.println(solution.hasCommonAncestor(parentChildPairs1, 5,3));
//        for(List<Integer> result: results) {
//            System.out.println(result.toString());
//        }
    }

}
