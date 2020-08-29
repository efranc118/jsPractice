package main.strings;

/*
We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if
A can become B after some number of shifts on A.
*/

public class RotateString {


    public boolean rotateString(String A, String B) {

        if(A.length() != B.length()) return false;
        if(A.length() == 0) return true;
        for(int i = 0; i < B.length(); i++) {
            if(B.charAt(i) == A.charAt(0)) {
                String test = B.substring(i) + B.substring(0, i);
                if (test.equalsIgnoreCase(A)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString solution = new RotateString();
        System.out.println(solution.rotateString("leiyuedtiw",
                "uedtiwleiy"));
    }

}
