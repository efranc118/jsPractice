package main.array;

import java.util.ArrayList;

public class FindMatrixMedian {

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int columnLen = A.get(0).size();
        int min = A.get(0).get(0);
        int max = A.get(0).get(columnLen - 1);

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i).get(0) < min) {
                min = A.get(i).get(0);
            }

            if(A.get(i).get(columnLen - 1) > max) {
                max = A.get(i).get(columnLen - 1);
            }
        }

        int medianLen = (A.size() * columnLen + 1) / 2;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            int place = 0;
            for(int i = 0; i < A.size(); i++) {
                 count = findLowIndex(A.get(i), mid);
                 while(count < A.get(i).size() && A.get(i).get(count) == mid)
                    count++;
                 place += count;
            }
            if(place == medianLen) return mid;
            if(place < medianLen) min = mid + 1;
            else max = mid;
        }
        return -1;

    }



    public int findLowIndex(ArrayList<Integer> arr, Integer value) {
        int min = 0;
        int max = arr.size() - 1;

        while(min + 1 < max) {
            int mid = min + (max - min) / 2;
            if(arr.get(mid) >= value) max = mid;
            else min = mid + 1;
        }
        if(value >= arr.get(max)) return max;
        return -1;
    }

    public int findHighIndex(ArrayList<Integer> arr, Integer value, Integer max) {
        int min = 0;

        while(min < max) {
            int mid = min + (max - min) / 2;
            if(arr.get(mid) <= value) min = mid + 1;
            else max = mid;
        }
        if(value <= arr.get(min)) return min - 1;
        return -1;
    }


    public static void main(String[] args) {
        FindMatrixMedian solution = new FindMatrixMedian();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arr0 = new ArrayList<>();
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        ArrayList<Integer> arr2 = new ArrayList<>();
        //1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3
        arr0.add(0,3);
        arr0.add(0,3);
        arr0.add(0,3);
        arr0.add(0,3);
        arr0.add(0,3);
        arr0.add(0,3);
        arr0.add(0,2);
        arr0.add(0,2);
        arr0.add(0,2);
        arr0.add(0,2);
        arr0.add(0,1);
//        arr1.add(0,9);
//        arr1.add(0,6);
//        arr1.add(0,2);
//        arr2.add(0,9);
//        arr2.add(0,6);
//        arr2.add(0,3);
//        arrayLists.add(0,arr2);
//        arrayLists.add(0,arr1);
        arrayLists.add(0,arr0);

        System.out.println(solution.findMedian(arrayLists));
    }

}
