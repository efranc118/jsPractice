package main.binarysearch;

import java.util.*;

public class BinarySearching {

    int binarySearchTemplate1(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) min = mid + 1;
            else max = mid - 1;
        }
        return -1;
    }

    /**
     * Binary Search Current item + right neighbor
     * - Use element's right neighbor to determine if condition is met & decide
     * whether to go left or right
     * - Guarantees search space is at least 2 in size at each step
     * - Post-processing required. Loop/Recursion ends when you have 1 element
     * left. Need to asses if the remaining element meets the condition
     */

    int binarySearchTemplate2(int [] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }


        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    /**
     * Template 3 used for searching left & right of the current index
     *
     */
    int binarySearchTemplate3(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;


        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                left = mid;
            } else right = mid;
        }


        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int closestPosition = getClosestElementPosition(arr, x);
        if(k == 1) {
            result.add(arr[closestPosition]);
        }
        else {
            int lowPtr = closestPosition - (k - 1);
            int highPtr = closestPosition + (k - 1);
            lowPtr = lowPtr >= 0 ? lowPtr : 0;
            highPtr = highPtr >= arr.length ? arr.length - 1: highPtr;
            while (highPtr - lowPtr >= k)
            {
                int lowDiff = arr[lowPtr] < x ? x - arr[lowPtr] : arr[lowPtr] - x;
                int highDiff = arr[highPtr] < x ? x - arr[highPtr] : arr[highPtr] - x;

                if (lowDiff <= highDiff){
                    highPtr--;
                }
                else {
                    lowPtr++;
                }

            }

            while(lowPtr <= highPtr) {
                result.add(arr[lowPtr++]);
            }
        }
        return result;
    }

    public int getClosestElementPosition(int[] arr, int x) {
        int min = 0;
        int max = arr.length - 1;
        while(min + 1 < max) {
            int mid = min + (max - min) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > x) max = mid;
            else min = mid;
        }
        if(arr[min] == x) return min;
        if(arr[max] == x) return max;
        int minDiff = arr[min] < x ? x - arr[min] : arr[min] - x;
        int maxDiff = arr[max] < x ? x - arr[max] : arr[max] - x;
        return minDiff <= maxDiff ? min : max;
    }

    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;


        while(min < max) {
            int mid = min + (max - min) / 2;
            if(isBadVersion(mid)) max = mid;
            else min = mid + 1;
        }

        if(isBadVersion(min)) return min;
        return -1;
    }

    public boolean isBadVersion(int value) {
        return value >= 3;
    }


    int BinarySearchRotatedArray(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[min] && target > nums[mid]) min = mid + 1;
            else if(nums[mid] >= nums[min] && target < nums[mid] && target >= nums[min]) max = mid - 1;
            else if(nums[mid] >= nums[min] && target < nums[mid] && target < nums[min]) min = mid + 1;

            else if(nums[mid] < nums[min] && target > nums[mid] && target < nums[min]) min = mid + 1;
            else if(nums[mid] < nums[min] && target > nums[mid] && target >= nums[min]) max = mid - 1;
            else if(nums[mid] < nums[min] && target < nums[mid]) max = mid - 1;
        }

        return -1;

    }



//    public int[] searchRange(int[] nums, int target)    {
//        if(nums == null || nums.length == 0) return new int[]{-1,-1};
//        if(nums.length == 1 && target == nums[0]) return new int[] {0,0};
//        int left = 0; int right = nums.length - 1;
//
//        while(left < right) {
//            int mid = left + (right - left) / 2;
//            if(nums[mid] >= target) right = mid;
//            else left = mid + 1;
//        }
//        int minRange = nums[right] == target ? right : -1;
//
//        left = 0;
//        right = nums.length - 1;
//        while(left < right) {
//            int mid = left + (right - left) / 2;
//            if(nums[mid] > target) right = mid;
//            else left = mid + 1;
//        }
//        int maxRange = -1;
//        if (nums[left] == target) maxRange = left;
//        else maxRange = left - 1 >= 0 && left - 1 < nums.length && nums[left - 1] == target ? left - 1 : -1;
//        return new int[] {minRange,maxRange};
//    }

    public int search(int[] reader, int target) {
        int low = 0;
        int high = 2;

        while(checkArray(reader, high) <= target) {
            low = high;
            high = high * 2;
        }
        while(low < high) {
            int mid = low + (high - low) / 2;
            int midVal = checkArray(reader, mid);
            if(midVal == target) return mid;
            if(midVal > target) high = mid - 1;
            if(midVal < target) low = mid + 1;
        }
        if(checkArray(reader, low) == target) return low;
        return -1;

    }

    public int checkArray(int[] arr, int input) {
        if (input >= arr.length) return 2147483647;
        else return arr[input];
    }

    public int[] searchRange(int[] nums, int target) {
        int min = 0;
        int max = nums.length -1;
        int start = 0;
        int end = 0;
        while(min < max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] >= target) {
                max = mid;
            }
            else min = mid + 1;
        }
        if(nums[max] != target) return new int[] {-1,-1};
        else start = max;

        min = 0;
        max = nums.length - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;
            if(nums[mid] > target) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        if(nums[min] == target) end = min;
        else if(nums[min - 1] == target) end = min - 1;
        return new int [] {start, end};

    }

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double mapInput = x;
        long power = 1;
        Map<Long, Double> memoize = new HashMap<>();
        while(power <= Math.abs(n)) {
            memoize.put(power, mapInput);
            power = power * 2;
            mapInput = mapInput * mapInput;
        }
        int remaining = Math.abs(n);
        Long[] array = memoize.keySet().toArray(new Long[0]);
        double result = 1;
        while(remaining > 0) {
            int min = 0;
            int max = array.length - 1;
            while(min < max) {
                int mid = min + (max - min) / 2;
                if(array[mid] == remaining) {
                    result = result * memoize.get(array[mid]);
                    if(n < 0) return (1 / result);
                    else return result;
                }
                if(array[mid] > remaining) max = mid - 1;
                else min = mid + 1;
            }
            result = result * memoize.get(array[min]);
            remaining = remaining - array[min].intValue();
        }
        if(n < 0) return (1 / result);
        return result;
    }



    public static void main(String[] args) {
        BinarySearching bs = new BinarySearching();
//        System.out.println(bs.BinarySearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 4));
//        System.out.println(bs.BinarySearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 0));
       // System.out.println(bs.BinarySearchRotatedArray(new int[]{4,5,6,7,0,1,2,3}, 0));
//        System.out.println(Arrays.toString(bs.searchRange(new int[]{5,7,7,8,8,10}, 7)));
//        System.out.println(bs.myPow(2.0000, 3));
//        System.out.println(bs.myPow(2.0000, -3));
        System.out.println(bs.myPow(1.72777,
                7));
//        System.out.println(bs.getClosestElementPosition(new int[]{1,2,4,5}, 3));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,4,5}, 4,3));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,4,5}, 4,5));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,4,5}, 4,10));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,4,5}, 3,-10));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,4,5}, 3,3));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,7,8,9}, 3,7));
//        System.out.println(bs.findClosestElements(new int[]{1,2,3,7,8,9}, 4,7));

//        System.out.println(bs.search(new int[] {-1,0,3,5,9,12}, 12));

    }
}
