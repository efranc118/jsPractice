package main.strings;

/*
 * Sometimes people repeat letters to represent extra feeling,
 * such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo",
 * we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications
 * of the following extension operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo",
 * but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension
 * like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy
 * because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy.
 *
 */

public class ExpressiveWords {




    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for(String word: words) {
        if(isStretchy(S, word)) count++;
        }
return count;
    }


    public boolean isStretchy(String s, String word) {
        int i, j;
        i = j = 0;

        while(i < s.length() && j < word.length()) {

            char currentChar = s.charAt(i);
            int sCount = 1;
            while(i < s.length() - 1 && s.charAt(i + 1) == currentChar){
                i++;
                sCount++;
            }

            int jCount = 0;
            while(j < word.length() && word.charAt(j) == currentChar) {
                j++;
                jCount++;
            }

            if(sCount > 1 && sCount < 3 && sCount != jCount || jCount > sCount) return false;

            i++;
        }
        if(j == word.length()) return true;
        return false;
    }


    public static void main(String[] args) {
        ExpressiveWords solution = new ExpressiveWords();
        System.out.println(solution.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"}));
    }

}
