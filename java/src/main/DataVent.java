package main;

import java.util.*;

public class DataVent {



//    public void reverseArray(String[] original, int start, int end) {
//
//        while(start < end) {
//            String temp = original[end];
//            original[end] = original[start];
//            original[start] = temp;
//            start++;
//            end--;
//        }
//
//    }
//
//
//    public String[] stringToArray(String original) {
//        String[] arr = new String[original.length()];
//
//        for(int i = 0; i < original.length(); i++) {
//            arr[i] = String.valueOf(original.charAt(i));
//        }
//        return arr;
//    }
//
//    public void reverseWordsInSentence(String[] original) {
//        reverseArray(original, 0, original.length - 1);
//        int startWord = 0;
//        int endWord = 1;
//        while(endWord < original.length) {
//            if(original[endWord].equals(" "))  {
//                reverseArray(original, startWord, endWord - 1);
//                while(original[endWord].equals(" ")) endWord++;
//                startWord = endWord;
//            }
//            endWord++;
//        }
//        if(original[--endWord] != " ") reverseArray(original, startWord, endWord);
//
//    }


    public boolean isFriendly(String first, String second) {

        String mappedFirst = getMapRepresentation(first);
        String mappedSecond = getMapRepresentation(second);
        return mappedFirst.equals(mappedSecond);
    }


    public String getMapRepresentation(String first) {
        Map<Character, Integer> map = new HashMap<>();
        String mapResult = "";
        int pos = 0;
        for(int i = 0; i < first.length(); i++) {
            if(map.containsKey(first.charAt(i))) {
                mapResult += map.get(first.charAt(i));
            }
            else {
                map.put(first.charAt(i), pos);
                mapResult += pos;
                pos++;
            }
        }
        return mapResult;
    }


    public String[] orderFriendlyWords(String[] words) {
        Map<String, List<String>> friendlyMap = new HashMap<>();
        String[] result = new String[words.length];
        for(String word: words) {
            String mapKey = getMapRepresentation(word);
            List<String> related = friendlyMap.getOrDefault(mapKey, new ArrayList<>());
            related.add(word);
            friendlyMap.put(mapKey, related);
        }


        int ptr = 0;
        for(List<String> wordList: friendlyMap.values()) {
            for(String word: wordList) {
                result[ptr++] = word;
            }
        }
        return result;
    }




    public static void main(String[] args) {
        DataVent solution = new DataVent();
//        String sentence = "Today is a nice day in Salt Lake City";
//        String[] result = solution.stringToArray(sentence);
//        System.out.println(Arrays.toString(result));
//        solution.reverseWordsInSentence(result);
//        System.out.println(Arrays.toString(result));

        String java = "JAVA";
        String polo = "POLO";
        String jeff = "JEFF";
        String less = "LESS";
        String check = "CHESSTLU";

        String[] arr = new String[]{java, jeff, less, check, polo};
        String[] result = solution.orderFriendlyWords(arr);

        System.out.println(Arrays.toString(result));

//        if(solution.isFriendly(java, polo)) System.out.println( java + " " + polo + " Correct");
//        if(!solution.isFriendly(java, jeff)) System.out.println(java + " " + jeff + " Incorrect");
//        if(!solution.isFriendly(java, less)) System.out.println(java + " " + less + " Incorrect");
//        if(solution.isFriendly(jeff, less)) System.out.println(jeff + " " + less + " Correct");
//        if(!solution.isFriendly(check, less)) System.out.println(check + " " + less + " Incorrect");
//        if(!solution.isFriendly(less, check)) System.out.println(less + " " + check + " Incorrect");
//        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
//        solution.reverseArray(arr, 0, 5);
//        System.out.println(Arrays.toString(arr)); //expected = a, b , e, d, c, f

    }

}
