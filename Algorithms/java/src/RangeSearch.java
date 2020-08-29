import java.util.Arrays;

public class RangeSearch {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        //Get lowest element if exists
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;

            if(nums[mid] >= target) max = mid - 1;
            else min = mid +1;
        }
        int min_position = max > nums.length -1 && nums[max] == target ? max : max + 1;

        if( min_position < 0 || min_position == nums.length || nums[min_position] != target) {
            return new int[]{-1, -1};
        }

        min = 0;
        max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;

            if(nums[mid] <= target) min = mid + 1;
            else max = mid - 1;
        }

        int max_position = min < nums.length && nums[min] == target ? min : min - 1;

        return new int[]{min_position, max_position};
    }

    public static void main(String[] args) {
        RangeSearch rangeSearch = new RangeSearch();
        int[] test = {0,1,2,3,4,4,4};
        System.out.println(Arrays.toString(rangeSearch.searchRange(test, 2)));
    }


}
