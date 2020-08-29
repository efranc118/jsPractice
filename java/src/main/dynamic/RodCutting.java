package main.dynamic;

public class RodCutting {

    public int cutRod(int price[], int n) {

        int[] optimizeCuts = new int[n + 1];
        optimizeCuts[0] = 0;
        for(int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                int totalValue = price[j]  + optimizeCuts[i - j - 1];
                maxValue = Math.max(totalValue, maxValue);
            }
            optimizeCuts[i] = maxValue;
        }

        return optimizeCuts[n];
    }

    public static void main(String[] args) {
        RodCutting solution = new RodCutting();
        long startTime = System.nanoTime();
        System.out.println(solution.cutRod(new int[]{1,5,8,9,10,17,17,20},8));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

}
