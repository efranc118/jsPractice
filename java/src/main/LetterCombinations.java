package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    List<String> results = new ArrayList<>();
    Map<Character, String> keyMap = new HashMap<>();

    LetterCombinations() {
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        Map<Character, String> keyMap = new HashMap<>();
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");

        for(int i = 0; i< digits.length(); i++) {
            String newValue = keyMap.get(digits.charAt(i));
            result = addNewLetters(result, newValue);
        }
        return result;
    }

    private List<String> addNewLetters(List<String> arr, String newValues) {
        List<String> result = new ArrayList<>();
        if(arr.isEmpty()) {
            for(int i  = 0 ; i < newValues.length(); i++) {
                result.add(newValues.substring(i,i + 1));
            }
        } else {
            for(int i = 0; i < newValues.length(); i++) {
                for(int j = 0; j < arr.size(); j++) {
                    String newString = arr.get(j).concat(newValues.substring(i,i + 1));
                    result.add(newString);
                }
            }
        }
        return result;

    }


    public void backTracking(String currentString, String remainingDigits) {
        if(remainingDigits.length() == 0) results.add(currentString);
        else {
            String characters = keyMap.get(remainingDigits.charAt(0));
            for (int i = 1; i <= characters.length(); i++) {
                backTracking(currentString + characters.substring(i - 1, i), remainingDigits.substring(1));
            }
        }

    }


    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        System.out.println(solution.letterCombinations("23"));

        solution.backTracking("", "23");
    }

}
