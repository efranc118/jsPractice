package main.array;

import java.util.*;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        int firstPtr = 0;
        int secondPtr = 1;
        int thirdPtr = nums.length - 1;

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        while(firstPtr < nums.length - 2) {
            while(secondPtr < thirdPtr) {
                int curSum = nums[firstPtr] + nums[secondPtr] + nums[thirdPtr];
                if (curSum == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[firstPtr]);
                    result.add(nums[secondPtr]);
                    result.add(nums[thirdPtr]);
                    if(!resultSet.contains(result)) {
                        results.add(result);
                        resultSet.add(result);
                    }
                }

                if (curSum > 0) {
                    thirdPtr--;
                }
                else secondPtr++;
            }
            firstPtr++;
            secondPtr = firstPtr + 1;
            thirdPtr = nums.length - 1;
        }
    return results;
    }



    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
