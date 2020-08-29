package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(1, k, n, new ArrayList<>());
        return results;
    }




    public void combine(int i, int k, int n, List<Integer> curList) {
        if(curList.size() == k) results.add(new ArrayList<>(curList));
        else {
            for(int j = i; j <=n; ++j) {
                curList.add(j);
                combine(j + 1, k, n, curList);
                curList.remove(curList.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        Combinations solution = new Combinations();
        System.out.println(solution.combine(4,2));
    }

}
