package main;




import java.util.HashSet;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> values = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for(int num: nums1) {
            values.add(num);
        }

        for(int num: nums2) {
            if(values.contains(num)) intersection.add(num);
        }
        int[] result = new int[intersection.size()];
        Object[] arr = intersection.toArray();
        for(int i = 0; i < intersection.size(); i++) {
            result[i] = (int) arr[i];
        }
        return result;
    }


    public static void main(String[] args) {
        Intersection solution = new Intersection();
        //System.out.println(solution.intersection());
    }

}
