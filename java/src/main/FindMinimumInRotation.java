package main;

public class FindMinimumInRotation {

    public int findMin(int[] nums) {
        int min = 0;
        int max = nums.length - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] > nums[min]) min = mid;
            else max = mid;
        }
        return nums[0];
    }


    public static void main(String[] args) {
        FindMinimumInRotation fm = new FindMinimumInRotation();
        System.out.println(fm.findMin(new int[]{3,4,5,1,2}));
        System.out.println(fm.findMin(new int[]{4,5,6,7,1,2}));
        System.out.println(fm.findMin(new int[]{1,2,3,4,5}));
        System.out.println(fm.findMin(new int[]{2,3,4,1}));
    }

}
