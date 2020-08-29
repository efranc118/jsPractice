class RotationPointSearch {
    public int search(int[] nums, int target) {
        if(nums.length < 1) return -1;
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = (min + max) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[min]) {
                if(nums[mid] > target && nums[min] <= target) {
                    max = mid - 1;
                }
                else {
                    min = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[max]) {
                        min = mid  + 1;
                    }
                else {
                        max = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        RotationPointSearch solution = new RotationPointSearch();
        int[] test = {5,1,2,3,4};
        System.out.println(solution.search( test,1));
    }
}


/**
 class Solution {
 public int search(int[] nums, int target) {
 int start = 0, end = nums.length - 1;
 while (start <= end) {
 int mid = start + (end - start) / 2;
 if (nums[mid] == target) return mid;
 else if (nums[mid] >= nums[start]) {
 if (target >= nums[start] && target < nums[mid]) end = mid - 1;
 else start = mid + 1;
 }
 else {
 if (target <= nums[end] && target > nums[mid]) start = mid + 1;
 else end = mid - 1;
 }
 }
 return -1;
 }
 }

 **/
