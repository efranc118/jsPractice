public class PerfectSquare {


    public boolean isPerfectSquare(int num) {
        if(num == 0) return true;
        int low = 1;
        int high = 46340;
//        while(high * high <= num) {
//            low = high;
//            high = high * high;
//        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int value = mid * mid;
            if( value == num) return true;
            if(value > num) high = mid - 1;
            if(value < num) low = mid + 1;
        }
        return false;

    }

    public static void main(String[] args) {
        PerfectSquare solution = new PerfectSquare();
        System.out.println(solution.isPerfectSquare(16)); //true
        System.out.println(solution.isPerfectSquare(14)); //false
        System.out.println(solution.isPerfectSquare(100)); //true
        System.out.println(solution.isPerfectSquare(2108304)); //true
        System.out.println(solution.isPerfectSquare(2108304)); //true
        System.out.println(solution.isPerfectSquare(2147483647)); //false
        System.out.println(solution.isPerfectSquare(2081458129)); //true

    }

}
