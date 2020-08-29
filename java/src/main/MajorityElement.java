package main;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int count = n / 3;
        // Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            nums[j] = nums[j] - 1;

        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            nums[nums[i] % n] = nums[nums[i] % n] + n;

        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + "->" + nums[i] / n);
            if ((nums[i] / n) > count) result.add(i + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(new int[] {3,2,3}));
    }

}
