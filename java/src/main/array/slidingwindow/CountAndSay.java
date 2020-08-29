package main.array.slidingwindow;

/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
You can do so recursively, in other words from the previous member read off the digits,
counting the number of digits in groups of the same digit.
 */

public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder nextResult = new StringBuilder();
            int currentCount = 0;
            int currentCharacter = Integer.parseInt(result.substring(0,1));
            for(int j = 0; j < result.length(); j++) {
                if(currentCharacter == Integer.parseInt(result.substring(j, j+ 1))) {
                    currentCount += 1;
                } else {
                    nextResult.append(String.valueOf(currentCount) + String.valueOf(currentCharacter));
                    currentCount = 1;
                    currentCharacter = Integer.parseInt(result.substring(j, j+ 1));
                }
            }
            nextResult.append(String.valueOf(currentCount) + String.valueOf(currentCharacter));
        result = nextResult.toString();
        }
    return result;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(5));
    }

}
