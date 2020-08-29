package main;

public class SingleNumber {

    public int singleNumber(int[] nums) {
    int value = nums[0];
    for(int i = 1; i < nums.length; i++) {
        value = value ^ nums[i];
    }
    return value;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(new int[]{1,1,3,6,6}));
    }

}
