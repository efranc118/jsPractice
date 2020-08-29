package main.strings;

import java.util.Arrays;

public class FirstUniqCharacter {

    public int firstUniqChar(String s) {
        int[] bitmask = new int[26];
        Arrays.fill(bitmask, 0);
        for(int i = 0; i< s.length(); i++) {
            char character = s.charAt(i);
            int value = character - 97;
            bitmask[value] += 1;
        }
        for(int i = 0; i< s.length(); i++) {
            char character = s.charAt(i);
            int value = character - 97;
            if(bitmask[value] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqCharacter solution = new FirstUniqCharacter();
        System.out.println(solution.firstUniqChar("leetcodelover"));
    }

}
