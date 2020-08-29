import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        Integer difference = Integer.MAX_VALUE;
        int returnSum = 0;
        int low = 0;
        while(low < nums.length - 2) {
            int mid = low + 1;
            int high = nums.length - 1;
            while(mid < high) {
                int curSum = nums[low] + nums[mid] + nums[high];
                int curDiff = Math.abs(target - curSum);
                if(curDiff < difference) {
                    returnSum = curSum;
                    difference = curDiff;
                }
                if(curSum > target) high--;
                else mid++;
            }
            low++;
        }
        return returnSum;

    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[] {1,2,4,8,16,32,64,128},
        82));
    }

}
