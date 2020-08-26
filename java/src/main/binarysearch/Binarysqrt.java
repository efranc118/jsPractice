package main;

public class Binarysqrt {


    public int sqrt(int A) {
        if(A == 1) return 1;
        int max = Integer.MAX_VALUE / 2;
        int min = 0;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            int midSquared = mid * mid;
            if(midSquared == A) return mid;
            else if(midSquared > A || midSquared < 0) max = mid - 1;
            else min = mid + 1;
        }
        return (min + max) / 2 ;


    }


    public static void main(String[] args) {
        Binarysqrt solution = new Binarysqrt();
        System.out.println(solution.sqrt(930675566));
    }

}
