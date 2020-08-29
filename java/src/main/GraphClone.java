package main;

import java.util.*;

public class GraphClone {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

//
//    class Solution {
//        HashSet<Node> visited = new HashSet<>();
//
//        public Node cloneGraph(Node node) {
//            Queue<Node> queue = new LinkedList<>();
//
//            queue.add(node);
//
//            while(!queue.isEmpty()) {
//                Node curNode = queue.remove();
//
//
//            }
//        }
//    }

    public static void main(String[] args) {
        GraphClone solution = new GraphClone();
//        System.out.println(solution.solve());
    }




}
