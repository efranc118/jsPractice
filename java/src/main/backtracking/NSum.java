package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NSum {


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(target,  0, new ArrayList<>(), candidates);
        return result;
    }




    public void combinationSum(int target, int position, List<Integer> curList, int[] candidates) {
            if(position >= candidates.length || target < 0) return;
            if(target == 0) {
                result.add(new ArrayList<>(curList));
            }
            else {
                curList.add(candidates[position]);
                combinationSum(target - candidates[position], position, curList, candidates);
                curList.remove(curList.size() - 1);
                combinationSum(target, position + 1, curList, candidates);
            }

    }




    public static void main(String[] args) {
        NSum solution = new NSum();
        System.out.println(solution.combinationSum(new int[] {2,3,6,7}, 7));
    }

}
