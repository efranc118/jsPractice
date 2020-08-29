package main.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchInstanceCount {


    public int findCount(final List<Integer> A, int B) {
        int min = 0;
        int max = A.size() - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;

            if(A.get(mid) < B) min = mid + 1;
            if(A.get(mid) >= B) max = mid;
        }
        int low = min;


        min = 0;
        max = A.size() - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;

            if(A.get(mid) > B) max = mid;
            if(A.get(mid) <= B) min = mid + 1;
        }
        int high = max;

        return high - low;
    }

    public static void main(String[] args) {
        BinarySearchInstanceCount solution = new BinarySearchInstanceCount();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(7);
        arr.add(7);
        arr.add(7);
        arr.add(7);
        arr.add(7);
        System.out.println(solution.findCount(arr, 7));
    }

}
