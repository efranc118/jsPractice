package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> anagrams = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        for(String str: strs) {

            List<Integer> key = getKey(str);
            if(!anagrams.containsKey(key)) anagrams.put(key, new ArrayList<>(Arrays.asList(str)));
            else anagrams.get(key).add(str);
        }

        results.addAll(anagrams.values());
        return results;
    }


    public List<Integer> getKey(String curString) {

        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
        for(int i = 0; i < curString.length(); i++) {
            key.set(curString.charAt(i) - 'a', key.get(curString.charAt(i) - 'a') + 1);
        }
        return key;
    }


    public static void main(String[] args) {
        Anagrams solution = new Anagrams();
        System.out.println(solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
