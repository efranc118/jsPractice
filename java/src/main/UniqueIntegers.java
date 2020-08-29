package main;

import java.util.HashMap;
import java.util.PriorityQueue;

public class UniqueIntegers {


    public int removeIntegers(int[] arr, int k) {

        HashMap<Integer, Integer> mapCounts = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(!mapCounts.containsKey(arr[i])) mapCounts.put(arr[i], 1);
            else mapCounts.put(arr[i], mapCounts.get(arr[i]) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] >= b[1]) return 1;
            else return -1;
        });

        for(Integer key: mapCounts.keySet()) {
            pq.add(new int[] {key, mapCounts.get(key)});
        }


        int keysToRemove = k;
        while(keysToRemove > 0) {
            int[] values = pq.peek();
            keysToRemove = keysToRemove - values[1];
            if(keysToRemove >= 0) {
                pq.remove();
            }
        }
        return pq.size();
    }



    public static void main(String[] args) {
        UniqueIntegers solution = new UniqueIntegers();
        System.out.println(solution.removeIntegers(new int[] {4,3,1,1,3,3,2}, 3));
        System.out.println(solution.removeIntegers(new int[] {1}, 1));
    }

}
