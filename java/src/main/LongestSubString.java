import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

//    public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) return 0;
//        if(s.length() == 1) return 1;
//        Set<Character> alreadySeen = new HashSet<>();
//        int currentLength = 0;
//        int currentMax = 0;
//        int subMax = lengthOfLongestSubstring(s.substring(1));
//        for(int i = 0 ; i < s.length(); i++) {
//            if(alreadySeen.contains(s.charAt(i))) {
//                break;
//            } else{
//                alreadySeen.add(s.charAt(i));
//                currentLength++;
//                if(currentLength > currentMax) currentMax = currentLength;
//            }
//        }
//        if(currentMax < subMax) currentMax = subMax;
//        return currentMax;
//    }

    public int lengthOfLongestSubstringOptimized(String s) {
        if(s.length() < 2) return s.length();
        HashSet<Character> currentSubStringChars = new HashSet<>();
        int startPtr = 0;
        int endPtr = 1;
        currentSubStringChars.add(s.charAt(startPtr));
        int maxSubStringLength = 0;
        while(endPtr < s.length()) {
            if(!currentSubStringChars.contains(s.charAt(endPtr))){
                currentSubStringChars.add(s.charAt(endPtr));
                endPtr++;
                if(currentSubStringChars.size() > maxSubStringLength) maxSubStringLength = currentSubStringChars.size();
            } else {
                while(currentSubStringChars.contains(s.charAt(endPtr))) {
                    currentSubStringChars.remove(s.charAt(startPtr));
                    startPtr++;
                }
            }
        }
        return maxSubStringLength;

    }



public static void main(String[] args) {
    LongestSubString ls = new LongestSubString();

System.out.println(ls.lengthOfLongestSubstringOptimized("abcabcabc"));
System.out.println(ls.lengthOfLongestSubstringOptimized("bbbbb"));
System.out.println(ls.lengthOfLongestSubstringOptimized("pwwkew"));


}





}
