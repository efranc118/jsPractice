package main.array;

public class SearchRotatedArray {





    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int rotationPoint = findRotationPoint(nums);
        if(target >= nums[rotationPoint] && target <= nums[max]) return binarySearch(rotationPoint, max, nums, target);
        return binarySearch(min, rotationPoint - 1, nums, target);
    }

    public int findRotationPoint(int[] nums) {
        int min = 0;
        int max = nums.length - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] > nums[mid + 1]) return mid + 1;
            if(nums[mid] > nums[max]) min = mid;
            if(nums[mid] < nums[min]) max = mid;
            else min = mid + 1;
        }
        return max;
    }

    public int binarySearch(int min, int max, int[] nums, int target) {

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) max = mid - 1;
            else if(nums[mid] < target) min = mid + 1;
        }
        return -1;
    }


    public boolean binarySeach(int min, int max, int[] nums, int target) {

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) return true;
            else if (nums[min] == nums[max]) {
                if (target == nums[min]) return true;
                else {
                    min++;
                    max--;
                }
            } else if (nums[mid] > target) max = mid - 1;
            else if (nums[mid] < target) min = mid + 1;
        }
        return false;
    }


    public static void main(String[] args) {
        SearchRotatedArray solution = new SearchRotatedArray();
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2,3}, 6));
    }

}
