package main.dynamic;


import java.util.HashMap;
import java.util.Map;

public class StairClimb {

    Map<Integer, Integer> cache = new HashMap<>();

    //Top Down Solution
    public int climbStairsTD(int n) {
        if(n < 3) return n;
        if(cache.containsKey(n)) return cache.get(n);
        Integer result = climbStairsTD(n - 1) + climbStairsTD(n - 2);
        cache.put(n, result);
        return result;
    }

    //Bottom Up Approach
    public int climbStairsBU(int n) {
        //Bottom up always is iterative
        if(n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        StairClimb solution = new StairClimb();
        System.out.println(solution.climbStairsBU(5));
        System.out.println(solution.climbStairsTD(5));
    }

}
