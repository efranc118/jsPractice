package main.dynamic;

public class LongestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        int count = 0;
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) count++;
                dp[i][j] = count;
            }
        }

        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        LongestCommonSubSequence solution = new LongestCommonSubSequence();
        System.out.println(solution.longestCommonSubsequence("abcdegh", "acefh"));
    }

}
