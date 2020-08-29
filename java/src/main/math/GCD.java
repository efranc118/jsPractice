package main.math;

public class GCD {


    public int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd( b % a, a);
    }

    public int generalizedGCD(int num, int[] arr)
    {

        int result = arr[0];
        for(int i = 1; i < num; i++) {
            result = gcd(arr[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        GCD solution = new GCD();
        System.out.println(solution.generalizedGCD(5, new int[] {5, 30, 100, 10, 65}));
    }

}
