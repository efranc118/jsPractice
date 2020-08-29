package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParenPermutations {

    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList<>();
        results.add(" ");
        for(int i = 0; i < n; i++) {
            results = generateParens(results);
        }

        return results;
    }



    public List<String> generateParens(List<String> currentCombinations) {

        Set<String> results = new HashSet<String>();
        for(String curString: currentCombinations) {
            for(int i = 0;i < curString.length(); i++) {
                results.add(curString.substring(0, i) + "()" + curString.substring(i));
            }
        }

        return new ArrayList<String>(results);
    }


    public static void main(String[] args) {
        ParenPermutations solution = new ParenPermutations();
        System.out.println(solution.generateParenthesis(3));
    }

}
