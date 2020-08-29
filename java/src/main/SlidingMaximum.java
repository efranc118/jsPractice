package main;

import java.util.*;

public class SlidingMaximum {



    // Heap Attempt
//    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
//
//        if(B > A.size() || B < 1) return new ArrayList<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> {
//            if(o1 > o2) return -1;
//            if(o1 < o2) return 1;
//            return 0;
//        });
//        for(int i = 0; i < B; i++) {
//            pq.add(A.get(i));
//        }
//
//        ArrayList<Integer> windowMax = new ArrayList<>();
//        windowMax.add(pq.peek());
//        for(int i = B; i < A.size(); i++) {
//            pq.remove(A.get(i - B));
//            pq.add(A.get(i));
//            windowMax.add(pq.peek());
//        }
//        return windowMax;
//
//    }


    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    List<Integer> nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums.get(i) > nums.get(deq.getLast())) deq.removeLast();
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> nums, int k) {
        int n = nums.size();
        if (n * k == 0) return new ArrayList<>();
        if (k == 1) return (ArrayList<Integer>) nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums.get(i) > nums.get(max_idx)) max_idx = i;
        }
        ArrayList<Integer> output = new ArrayList<>(n - k + 1);
        output.add(nums.get(max_idx));

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output.add(nums.get(deq.getFirst()));
        }
        return output;
    }


    public static void main(String[] args) {
        SlidingMaximum solution = new SlidingMaximum();
        System.out.println(solution.slidingMaximum(Arrays.asList(new Integer[] {1, 3, -1, -3, 5, 3, 6, 7}), 3));
    }

}
