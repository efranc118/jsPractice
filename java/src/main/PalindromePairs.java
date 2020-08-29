package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//TODO: Need to finish this one
public class PalindromePairs {


    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        HashMap<List<Integer>, List<String>> potentialPalindromes = new HashMap<>();

        for(String word: words) {
            List<Integer> bitmap = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            for(Character character: word.toCharArray()) {
                int ptr = character - 'a';
                bitmap.set(ptr, 1);
            }
            if(potentialPalindromes.containsKey(bitmap)) {
                List<String> list = potentialPalindromes.get(bitmap);
                list.add(word);
            }
            else potentialPalindromes.put(bitmap, Arrays.asList(word));
        }

        for(List<String> list: potentialPalindromes.values()) {
            for(int i = 0; i<= list.size() / 2; i++) {
                for(int j = i + 1; j < list.size(); j++) {
                    if(isPalindrome(list.get(i) + list.get(j))) {
                        results.add(Arrays.asList(i, j));
                        results.add(Arrays.asList(j, i));
                    }
                }
            }

        }

        return results;

    }


    Boolean isPalindrome(String candidate) {

        int low = 0;
        int high = candidate.length() - 1;

        while(low < high) {
            if(candidate.charAt(low) != candidate.charAt(high)) return false;
            low++;
            high--;
        }
        return true;

    }

    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        System.out.println(solution.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));
    }

}
