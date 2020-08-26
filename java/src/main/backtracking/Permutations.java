package main;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(new ArrayList<>(), nums);
        return results;
    }

    public void backTrack(List<Integer> curNums, int[] nums) {
        if(curNums.size() == nums.length) results.add(new ArrayList(curNums));
        for(int i = 0; i < nums.length; ++i) {
            if(!curNums.contains(nums[i])) {
                curNums.add(nums[i]);
                backTrack(curNums, nums);
                curNums.remove(curNums.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[]{1,1,3}));
    }

}
