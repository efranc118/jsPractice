package main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingMax {

    Deque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    public void cleanQueue(int i, int k) {
        // remove indexes of elements not from sliding window
        if(!deque.isEmpty() && deque.getFirst() == i - k) deque.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[i] ) deque.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];


        int max_index = 0;
        this.nums = nums;
        for(int i = 0; i < k; i++) {
            cleanQueue(i, k);
            deque.addLast(i);
            if(deque.peekFirst() == i) max_index = i;
        }

        result[0] = nums[max_index];

        for(int i = k; i < nums.length; i++) {
            cleanQueue(i, k);
            deque.addLast(i);
            result[i - (k - 1)] = nums[deque.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingMax solution = new SlidingMax();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

}
