package main.graph;

import java.util.*;

public class ForestMoves {

    class Point {
        public Integer x;
        public Integer y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Journey {
        public Point point;
        public Integer count;

        Journey(Point point, Integer count) {
            this.point = point;
            this.count = count;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {


        int minSteps = 0;
        Point start = new Point(0,0);
        List<int[]> trees = findTrees(forest);
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < trees.size(); i++) {
            Point end = new Point(trees.get(i)[1], trees.get(i)[2]);
            int minStepsToNextTree = findMinSteps(forest, start, end);
            if(minStepsToNextTree < 0) return -1;
            minSteps += minStepsToNextTree;
            forest.get(end.x).set(end.y, 1);
            start = end;
        }

        return minSteps;
    }



    public List<int[]> findTrees(List<List<Integer>> forest) {

        List<int[]> trees = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                if(forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        return trees;
    }


    public Integer findMinSteps(List<List<Integer>> forest, Point start, Point end) {
        Queue<Journey> stack = new LinkedList<>();
        int[][] visited = new int[forest.size()][forest.get(0).size()];
        stack.add(new Journey(start, 0));
        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};
        while(!stack.isEmpty()) {
            Journey cur = stack.poll();
            visited[cur.point.x][cur.point.y] = 1;
            if(cur.point.x.equals(end.x) && cur.point.y.equals(end.y)) return cur.count;
            else {
                for(int i  = 0; i < dx.length; i++) {
                    int nextX = cur.point.x + dx[i];
                    int nextY = cur.point.y + dy[i];
                    if(nextX >= 0 && nextX < forest.size() &&
                            nextY >= 0 && nextY < forest.get(0).size() &&
                            visited[nextX][nextY] == 0 && forest.get(nextX).get(nextY) > 0) {
                        visited[nextX][nextY] = 1;
                        Point nextPoint = new Point(cur.point.x + dx[i], cur.point.y + dy[i]);
                        stack.add(new Journey(nextPoint, cur.count + 1));
                    }
                }
            }
        }
        return -1;
    }


    /*
    [[54581641,64080174,24346381,69107959],
    [86374198,61363882,68783324,79706116],
    [668150,92178815,89819108,94701471],
    [83920491,22724204,46281641,47531096],
    [89078499,18904913,25462145,60813308]]
     */
    public static void main(String[] args) {
        ForestMoves solution = new ForestMoves();
        List<List<Integer>> forest = new ArrayList<>();
        Integer[] arr = new Integer[]{54581641,64080174,24346381,69107959};
        Integer[] arr2 = new Integer[]{86374198,61363882,68783324,79706116};
        Integer[] arr3 = new Integer[]{668150,92178815,89819108,94701471};
        Integer[] arr4 = new Integer[]{83920491,22724204,46281641,47531096};
        Integer[] arr5 = new Integer[]{89078499,18904913,25462145,60813308};
//        Integer[] arr = new Integer[]{10,9,5};
//        Integer[] arr2 = new Integer[]{7,6,8};
//        Integer[] arr3 = new Integer[]{4,3,2};
        List<Integer> row = Arrays.asList(arr);
        List<Integer> row2 = Arrays.asList(arr2);
        List<Integer> row3 = Arrays.asList(arr3);
        List<Integer> row4 = Arrays.asList(arr4);
        List<Integer> row5 = Arrays.asList(arr5);
        forest.add(row);
        forest.add(row2);
        forest.add(row3);
        forest.add(row4);
        forest.add(row5);

        System.out.println(solution.cutOffTree(forest));
    }

}
