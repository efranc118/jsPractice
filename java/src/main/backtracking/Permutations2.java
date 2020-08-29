package main.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {

        HashSet<List<Integer>> results = new HashSet<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            backTrack(new ArrayList<>(), nums, new ArrayList<>());
            return new ArrayList<>(results);
        }

        public void backTrack(List<Integer> curNums, int[] nums, List<Integer> alreadyProcessed) {
            if(curNums.size() == nums.length && !results.contains(curNums)) results.add(new ArrayList(curNums));
            for(int i = 0; i < nums.length; ++i) {
                if(!alreadyProcessed.contains(i) && curNums.size() < nums.length) {
                    curNums.add(nums[i]);
                    alreadyProcessed.add(i);
                    backTrack(curNums, nums, alreadyProcessed);
                    curNums.remove(curNums.size() - 1);
                    alreadyProcessed.remove(alreadyProcessed.size() - 1);
                }
            }

        }


    public static void main(String[] args) {
        Permutations2 solution = new Permutations2();
        System.out.println(solution.permuteUnique(new int[] {1,1,3}));
    }

}
