package main.strings;

public class ReverseStringRecursive {


    String reverseString(String newString, String remainingString) {
        if(remainingString.length() == 0) return newString;
        else {
            newString += remainingString.substring(remainingString.length() - 1);
        }
        return reverseString(newString, remainingString.substring(0, remainingString.length() - 1));
    }

    public static void main(String[] args) {
        ReverseStringRecursive solution = new ReverseStringRecursive();
        System.out.println(solution.reverseString("", "hello"));
    }
}
