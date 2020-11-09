package main.strings;

import java.util.HashMap;

/*
 *
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your
 * secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but
 * locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive
 * the secret number.

Write a function to return a hint according to the secret number and friend's guess,
use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.
 */
public class BullsCows {

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(Character s: secret.toCharArray()) {
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i< guess.length(); i++) {
            Character s = secret.charAt(i);
            Character g = guess.charAt(i);
            if(h.containsKey(g)) {
                if(s == g) {
                    bulls++;

                    if(h.get(g) <= 0) {
                        cows--;
                    }
                }
                else {
                    if(h.get(g) > 0) {
                        cows++;
                    }
                }
                h.put(g, h.get(g) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsCows solution = new BullsCows();
        System.out.println(solution.getHint("1123", "0111"));
    }

}
