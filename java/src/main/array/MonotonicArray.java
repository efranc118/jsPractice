package main.array;

public class MonotonicArray {

        public boolean isMonotonic(int[] A) {
            boolean isIncreasing = true;
            boolean isDecreasing = true;
            for(int i = 0; i < A.length - 1; i++) {
                if(isIncreasing && A[i] > A[i + 1]) isIncreasing = false;
                if(isDecreasing && A[i] < A[i + 1]) isDecreasing = false;
            }
            return isIncreasing || isDecreasing;
        }


    public static void main(String[] args) {
        MonotonicArray solution = new MonotonicArray();
        System.out.println(solution.isMonotonic(new int[] {1,1,1,2,3,5,10}));
        System.out.println(solution.isMonotonic(new int[] {1,1,1,2,3,5,10}));
    }

}
