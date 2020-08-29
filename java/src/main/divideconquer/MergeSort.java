package main.divideconquer;

import java.util.Arrays;

public class MergeSort {

        public int[] sortArray(int[] nums) {
            mergeSort(0, nums.length, nums);
            return nums;
        }


        public void mergeSort(int start, int end, int[] nums) {
//            int mid = start + (end - start) / 2;
//            mergeSort(start, mid, nums);
//            mergeSort(mid + 1, end, nums);
//
//            for(int i = start; i < ; i++) {
//                if(nums[i] > nums[mid]) {
//                    swap(i, mid, nums);
//                }
//            }

        }


        public void swap(int first, int second, int[] nums) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 3, 10, 7, 2, 8})));
    }

}
