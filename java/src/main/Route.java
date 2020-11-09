package main;

import java.util.Arrays;

public class Route {


//    public boolean subSetSum(int[] nums, int total) {
//        return subSetSum(nums, total, 0, 0);
//    }
//
//
//    public boolean subSetSum(int[] nums, int total, int curSum, int ptr) {
//        if(curSum == total) return true;
//        if(curSum > total || ptr >= nums.length) return false;
//        return subSetSum(nums, total, curSum + nums[ptr], ptr + 1) || subSetSum(nums, total, curSum, ptr + 1);
//    }
//
//
//    public boolean blackBox(boolean[] arr) {
//        System.out.println(Arrays.toString(arr));
//        return false;
//    }
//
//
//    //Return true if any combination from blackBox returns true
//    public boolean satisfy(Integer arrLength) {
//        for(int i = 0; i <= arrLength; i++) {
//            ArrayList<boolean[]> totalSet = new ArrayList<>();
//            getBooleanArgs(i, new boolean[i], 0, totalSet);
//            for(boolean[] arg: totalSet) {
//                if(blackBox(arg)) return true;
//            }
//        }
//        return false;
//    }
//
//
//    void getBooleanArgs(Integer length, boolean[] curSet, int ptr, List<boolean[]> totalSet) {
//        if(length == 0) {
//            totalSet.add(Arrays.copyOf(curSet, curSet.length));
//            return;
//        }
//        curSet[ptr] = false;
//        getBooleanArgs(length - 1, curSet, ptr + 1, totalSet);
//        curSet[ptr] = true;
//        getBooleanArgs(length - 1, curSet, ptr + 1, totalSet);
//    }


    //






//Order matters, not sure about formula
    //given a length of values for array, can we hand anything to blackbox?
    public static void main(String[] args) {
        Route solution = new Route();

//        UnRolledLL example = new UnRolledLL(new Integer[] {1,2,3,4,5,6,7,8,9}, 2);
//        System.out.println(example.getIndex(5));
//        example.addIndex(7, 4);
//        System.out.println(example.getIndex(4));

    }

}

//class UnRolledLL {
//
//    Integer[] arr;
//    UnRolledLL next;
//
//    public UnRolledLL(Integer[] initalArr, Integer size) {
//
//        arr = Arrays.copyOfRange(initalArr, 0, size);
//        if(initalArr.length > size) {
//            this.next = new UnRolledLL(Arrays.copyOfRange(initalArr, size, initalArr.length), size);
//        }
//    }
//
//
//    public Integer getIndex(Integer val) {
//        int jump = val / arr.length;
//        int pos = val % arr.length;
//        UnRolledLL ptr = this;
//
//        for(int i = 0; i < jump; i++) {
//            ptr = ptr.next;
//        }
//        return ptr.arr[pos];
//    }
//
//    }
//
//}

