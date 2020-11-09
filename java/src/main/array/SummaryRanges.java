package main.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length < 1) return result;

        int start, end;
        start = 0;

        for(int i = 1; i < nums.length; i++) {
            if(Math.abs(nums[i] - nums[i - 1]) >= 2) {
                if (i - start < 2) result.add(String.valueOf(nums[start]));
                else result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i - 1]));
                start = i;
            }
        }
        if(nums.length - start < 2) result.add(String.valueOf(nums[start]));
        else result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[nums.length - 1]));
        return result;


    }



    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        //System.out.println(solution.summaryRanges(new int[] {0,1,2,4,5,7}));
        System.out.println(solution.summaryRanges(new int[] {-2147483648,-2147483647,2147483647}));
    }

}
