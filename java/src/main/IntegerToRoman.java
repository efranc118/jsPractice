import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {


    public String intToRoman(int num) {
        Map<Integer, String> conversion = new HashMap<>();
        conversion.put(1, "I");
        conversion.put(5, "V");
        conversion.put(10, "X");
        conversion.put(50, "L");
        conversion.put(100, "C");
        conversion.put(500, "D");
        conversion.put(1000, "M");
        int position = 0;
        StringBuilder result = new StringBuilder();
        while(num / Math.pow(10, position) > 1) {
            int digit = (int) (num / Math.pow(10, position) % 10);
            if(digit <= 3 && digit > 0) {
                int key = (int) (1 * Math.pow(10, position));
                for(int i = 0;i < digit; i++) {
                    result.insert(0, conversion.get(key));
                }
            }
            else if(digit == 4 || digit == 9) {
                int singleKey = (int) (1 * Math.pow(10, position));
                int greaterKey = (int)((digit + 1) * (1 * Math.pow(10, position)));
                result.insert(0, conversion.get(singleKey) + conversion.get(greaterKey));
            }
            else if(digit >= 5 && digit < 9) {
                int singleKey = (int) (1 * Math.pow(10, position));
                int fiveKey = (int) (5 * Math.pow(10, position));
                result.insert(0, conversion.get(fiveKey));
                for(int i = 5; i < digit; i++) {
                    result.insert(1, conversion.get(singleKey));
                }
            }
            position++;
        }

        return result.toString();
    }



    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
//        System.out.println(solution.intToRoman(3));
//        System.out.println(solution.intToRoman(5));
//        System.out.println(solution.intToRoman(8));
//        System.out.println(solution.intToRoman(9));
//        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(19));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));


    }
}
