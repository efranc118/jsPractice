package main.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalance {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] transaction: transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        return dfs(0, new ArrayList<>(map.values()));
    }

    private int dfs(int index, List<Integer> values) {
        if(index == values.size()) return 0;

        if( values.get(index) == 0) return dfs(index + 1, values);
        int ans = Integer.MAX_VALUE;

        for(int i = index + 1; i < values.size(); i++) {
            if(values.get(i) * values.get(index) > 0) continue;
            values.set(i, values.get(i) + values.get(index));
            ans = Math.min(ans, 1 + dfs(index + 1, values));
            values.set(i, values.get(i) - values.get(index));
            if(values.get(i) + values.get(index) == 0) break;
        }

        return ans;
    }




    public static void main(String[] args) {
        OptimalAccountBalance solution = new OptimalAccountBalance();
        System.out.println(solution.minTransfers(new int[][]{{0,1,10}, {2,0,5}}));
    }

}
