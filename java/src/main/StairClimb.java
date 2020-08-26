import java.util.HashMap;
import java.util.Map;

public class StairClimb {

    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if(n < 3) return n;
        if(cache.containsKey(n)) return cache.get(n);
        Integer result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }


    public static void main(String[] args) {
        StairClimb solution = new StairClimb();
        System.out.println(solution.climbStairs(4));
    }

}
