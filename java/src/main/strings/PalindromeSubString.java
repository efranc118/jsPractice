package main.strings;

public class PalindromeSubString {


    public String longestPalindrome(String s) {
        String result = "";
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = palLength(s, i, i);
            int len2 = palLength(s, i, i + 1);
            int maxIterationLen = Math.max(len1, len2);
            if(maxIterationLen > maxLen) {
                result = s.substring(i - (maxIterationLen - 1) / 2, (i + 1) + maxIterationLen / 2);
                maxLen = maxIterationLen;
            }
        }
        return result;

    }

    public int palLength(String s, int sPos, int ePos) {
        while(sPos >= 0 && ePos < s.length() &&
                s.charAt(sPos) == s.charAt(ePos)) {
            sPos--;
            ePos++;
        }
        return ePos - sPos - 1;

    }

    public static void main(String[] args) {
        PalindromeSubString solution = new PalindromeSubString();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

}
