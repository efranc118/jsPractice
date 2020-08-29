package main.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        checkCombination(candidates, 0, target, new ArrayList<>());
        return result;
    }


    public void checkCombination(int[] candidates, int position, int target, List<Integer> curResult) {
        if(position >= candidates.length) return;
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }

        curResult.add(candidates[position]);
        checkCombination(candidates, position,target - candidates[position], curResult);
        curResult.remove(curResult.size() - 1);
        checkCombination(candidates, position + 1, target, curResult);

    }


    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        System.out.println(solution.combinationSum(new int[] {2,3,6,7}, 7));
    }

}
