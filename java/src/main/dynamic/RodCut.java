package main.dynamic;

public class RodCut {


    public int cutRod(int[] prices, int length) {
        int[] dp = new int[length + 1];
        dp[0] = 0;


        for(int i = 1; i <= length; i++) {
            int maxValue = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                /*
                    we have new prices to consider at each iteration, so check all the prices against the previous
                    optimum values and save the maximum.
                 */
                int value = prices[i - j - 1] + dp[j];
                maxValue = Math.max(value, maxValue);
            }
            dp[i] = maxValue;
        }
        return dp[length];
    }

    public static void main(String[] args) {
        RodCut solution = new RodCut();
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 1)); //should be 1
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 2)); //should be 5
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 3)); //should be 8
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 4)); //should be 10
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 5)); //should be 13
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 6)); //should be
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 7));
        System.out.println(solution.cutRod(new int[] {1,5,8,9,10,17,17,20}, 8));
    }

}
