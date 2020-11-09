package main.dynamic;

public class LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return 0;
        int[] dp = new int[nums.length];

        dp[nums.length - 1] = 0;
        int max = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            int curMax = 0;
            for(int j = i + 1; j< nums.length; j++) {
                if(nums[i] < nums[j] && dp[j] >= curMax) {
                    curMax = dp[j] + 1;
                }
            }
            dp[i] = curMax;
            if(dp[i] > max) max = dp[i];
        }
        return max + 1;

    }


    public static void main(String[] args) {
        LongestIncreasingSubSequence solution = new LongestIncreasingSubSequence();
        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

}
