package main;

public class ReverseKCharacters {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int iterator = 0;
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            iterator++;
            if(iterator == k) {
                result.append(sb.reverse());
                sb = new StringBuilder();
            }
            if(iterator == 2 * k) {
                result.append(sb);
                sb = new StringBuilder();
                iterator = 0;
            }
        }
        if(iterator < k) result.append(sb.reverse());
        else result.append(sb);
        if(k >= s.length()) return result.reverse().toString();
        return result.toString();
    }


    public static void main(String[] args) {
        ReverseKCharacters solution = new ReverseKCharacters();
        System.out.println(solution.reverseStr(
                "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl",
                39));
    }

}
