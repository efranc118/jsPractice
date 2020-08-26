package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

        public boolean isAlienSorted(String[] words, String order) {
            if(words.length < 2) return true;
            Map<Character, Integer> orderMap = new HashMap<>();
            int count = 1;
            for(Character character: order.toCharArray()) {
                orderMap.put(character, count);
                count++;
            }


            for(int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                String second = words[i + 1];

                int minLength = Math.min(first.length(), second.length());
                for(int j = 0; j < minLength;j++) {
                    if(orderMap.get(first.charAt(j)) < orderMap.get(second.charAt(j))) break;
                    if(orderMap.get(first.charAt(j)) > orderMap.get(second.charAt(j))) return false;
                    if(j == minLength - 1 && first.length() > second.length()) return false;
                }

            }
            return true;
//            Arrays.sort(words, (first, second) -> {
//                int minLength = Math.min(first.length(), second.length());
//                for(int i = 0; i < minLength;i++) {
//                    if(orderMap.get(first.charAt(i)) < orderMap.get(second.charAt(i))) return 1;
//                    if(orderMap.get(first.charAt(i)) > orderMap.get(second.charAt(i))) return -1;
//                }
//                if(first.length() < second.length()) return 1;
//                else if(first.length() > second.length()) return -1;
//                return 0;
//            });


        }


    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();
        System.out.println(solution.isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

}
