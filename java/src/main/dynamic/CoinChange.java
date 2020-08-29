package main.dynamic;


import java.util.HashMap;

public class CoinChange {

    HashMap<Integer, Integer> dp = new HashMap<>();
    public int findMinimalChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if(dp.containsKey(amount)) return dp.get(amount);
        int count = Integer.MAX_VALUE;
        for(int coin: coins) {
            int ret = findMinimalChange(coins, amount - coin);
            if(ret < 0) continue;
            count = Math.min(count, ret + 1);
        }
        dp.put(amount, count);
        return count;
    }

//    public int findMinimalChangeDP(int[] coins, int amount) {
//        int[] dp = new int[amount];
//        dp[0] = 0;
//
//
//
//    }




    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        System.out.println(solution.findMinimalChange(new int[]{1, 3, 5}, 50));
    }

}
