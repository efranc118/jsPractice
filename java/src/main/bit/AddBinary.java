package main.bit;

import java.math.BigInteger;

public class AddBinary {

//    public String addBinary(String a, String b) {
//        Long operand1 = convertToBase10(a);
//        Long operand2 = convertToBase10(b);
//        Long total = operand1 + operand2;
//        return convertToBase2(total);
//    }
//
//
//    public Long convertToBase10(String base2) {
//
//        Long total = 0L;
//        for(int i = base2.length() - 1; i >= 0; i--) {
//            Character cur = base2.charAt(i);
//            if(cur == '1') total += (long) Math.pow(2, base2.length() - i - 1);
//        }
//        return total;
//    }
//
//    public String convertToBase2(Long value) {
//        if(value == 0) return "0";
//        Long curTotal = value;
//        String binary = "";
//        while(curTotal > 0) {
//            binary += curTotal % 2;
//            curTotal /= 2;
//        }
//        return new StringBuilder(binary).reverse().toString();
//    }

    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger answer, carry;
        while(y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }



    //"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    //"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
//        System.out.println(solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    System.out.println(solution.addBinary("11", "1"));
    }

}
