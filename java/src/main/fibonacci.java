import java.util.HashMap;
import java.util.Map;

public class fibonacci {

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        if(N < 2) {
            return N;
        };
        if(cache.containsKey(N)) return cache.get(N);
        Integer result = fib(N - 1) + fib(N - 2);
        cache.put(N, result);
        return result;
    }


    public static void main(String[] args) {
        fibonacci solution = new fibonacci();
        System.out.println(solution.fib(6));
    }

}
