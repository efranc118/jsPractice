package main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int val: nums) {
            numList.add(numList.size(),val);
        }

        backTrack(numList, new ArrayList<>(), new ArrayList<>());
    }

    public void backTrack(List<Integer> nums, List<Integer> curList, List<Integer> alreadyProcessed) {
        if(curList.size() == nums.size()) {
            if(!curList.equals(nums)) System.out.println(Arrays.toString(curList.toArray()));
        }
        else {
            int min = findMin(nums, alreadyProcessed);
            curList.add(nums.get(min));
            alreadyProcessed.add(min);
            backTrack(nums, curList, alreadyProcessed);
            curList.remove(curList.size() - 1);
            alreadyProcessed.remove(alreadyProcessed.size() - 1);
        }

    }

    public int findMin(List<Integer> nums, List<Integer> alreadyProcessed) {
        int minVal = Integer.MAX_VALUE;
        int min = -1;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) < minVal && !alreadyProcessed.contains(i)) {
                min = i;
                minVal = nums.get(min);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(new int[] {1,2,3});
    }

}
