class Solution {
    public int search(int[] nums, int target) {
        if(nums.length < 1) return -1;
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = (min + max) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[min]) {
                if(nums[mid] > target) {
                    if(nums[min] < target) {
                        max = mid - 1;
                    }
                    else {
                        min = mid + 1;
                    }
                }
                if(nums[mid] < target) {
                    min = mid + 1;
                }
            }
            else {
                if(nums[mid] < target) {
                    if(nums[max] < target) {
                        max = mid - 1;
                    }
                    else {
                        min = mid + 1;
                    }
                }
                if(nums[mid] > target) {
                    if(nums[min] > target) {
                        min = mid + 1;
                    }
                    else {
                        max = mid - 1;
                    }
                }
            }
        }
        return -1;
    }


    public void main(String[] args) {
        Solution solution = new Solution();

        solution.search([4,5,6,7,0,1,2], 0);
    }
}


