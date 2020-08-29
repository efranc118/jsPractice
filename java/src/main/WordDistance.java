package main;

import java.util.HashMap;

public class WordDistance {

    public static int deletion_distance(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) {
            if(map.containsKey(str1.charAt(i))) map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            else map.put(str1.charAt(i), 1);
        }

        int total = 0;
        for(Character key: str2.toCharArray()) {
            if(!map.containsKey(key)) {
                total++;
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
        for(Character key: map.keySet()) {
            total += map.get(key);
        }


    return total;

    }


    public static void main(String[] args) {
        WordDistance solution = new WordDistance();
        System.out.println(solution.deletion_distance("bat", "cat"));
    }

}
