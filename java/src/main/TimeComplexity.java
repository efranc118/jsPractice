package main;

public class TimeComplexity {


    public int timeComplexityCheck(int N) {
        int count = 0;
        for (int i = N; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TimeComplexity solution = new TimeComplexity();
        System.out.println(solution.timeComplexityCheck(10));
    }

}
