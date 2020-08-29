package main.array;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] increasingSum = new int[nums.length];
        int[] decreasingSum = new int[nums.length];
        int low = 1;
        int high = nums.length - 2;
        increasingSum[0] = 1;
        decreasingSum[nums.length - 1] = 1;
        while(low < nums.length && high >= 0) {
            increasingSum[low] = nums[low - 1] * increasingSum[low - 1];
            decreasingSum[high] = nums[high + 1] * decreasingSum[high + 1];
            low++;
            high--;
        }
        int[] result = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            result[i] = increasingSum[i] * decreasingSum[i];
        }
        return result;
    }


    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
