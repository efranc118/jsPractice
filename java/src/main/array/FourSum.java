package main.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

//    List<List<Integer>> results = new ArrayList<>();
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        backTrack(nums, 0, new ArrayList<>(), target);
//        return results;
//    }
//
//
//    public void backTrack(int[] nums, int pos, List<Integer> cur, int target) {
//        if(target == 0 && cur.size() == 4) {
//            results.add(new ArrayList<>(cur));
//            return;
//        }
//        if(pos >= nums.length) return;
//        if(cur.size() > 4) return;
//        cur.add(nums[pos]);
//        backTrack(nums, pos + 1, cur, target - nums[pos]);
//        cur.remove(cur.size() - 1);
//        backTrack(nums, pos + 1, cur, target);
//    }

//        public List<List<Integer>> fourSum(int[] nums, int target) {
//            List<List<Integer>> results =  new ArrayList<>();
//            Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = i + 1; j < nums.length; j++) {
//                List<Integer> curList = new ArrayList<>();
//                curList.add(nums[i]);
//                curList.add(nums[j]);
//                int curTarget = target - nums[i] - nums[j];
//                if(curTarget > 0) {
//                    curList.addAll(twoSum(nums, curTarget, j + 1));
//                    if(curList.size() == 4) results.add(curList);
//                }
//            }
//        }
//        return results;
//    }
//
//
//    public List<Integer> twoSum(int[] nums, int target, int start) {
//        int end = nums.length - 1;
//        ArrayList<Integer> result = new ArrayList<>();
//        while(start < end) {
//            int curVal = nums[start] + nums[end];
//            if(curVal == target) {
//                result.add(nums[start]);
//                result.add(nums[end]);
//                return result;
//            }
//            else if(curVal > target) end--;
//            else start++;
//        }
//        return result;
//    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }


    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }



    public static void main(String[] args) {
        FourSum solution = new FourSum();
        System.out.println(solution.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }

}
