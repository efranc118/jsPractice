import sun.security.krb5.internal.crypto.ArcFourHmac;

public class RotationPointFindItem {

    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[min]) {
            }
            else if(nums[mid] <= nums[max]) {
            }

        }
        return 0;
    }

    private int binarySearch(int[] nums,int min,int max,int target) {
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) max = mid - 1;
            else min = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        RotationPointFindItem rotationPointFindItem = new RotationPointFindItem();
        int[] test = {3,5,1};
        System.out.println(rotationPointFindItem.search(test, 0));
    }
}
