import java.util.ArrayList;

public class MaxSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        if(A.size() < 1) return new ArrayList<>();
        ArrayList<Integer> maxSubArray = new ArrayList<>();
        ArrayList<Integer> subArray = new ArrayList<>();
        long maxSum = Integer.MIN_VALUE;
        long curSum = 0;

        for(int i = 0; i < A.size(); i++) {
            long curVal = A.get(i);
            if(curVal >= 0) {
                subArray.add(A.get(i));
                curSum = curVal + curSum;
                if(curSum > maxSum || (curSum == maxSum && subArray.size() >= maxSubArray.size())) {
                    maxSum = curSum;
                    maxSubArray.clear();
                    maxSubArray = new ArrayList<>(subArray);
                }
            } else {
                subArray.clear();
                curSum = 0;
            }
        }

        return maxSubArray;


    }

    // [25150, 1412, 82797, 48381, 7065, -47699, -25129, -65483, -64607, -45322, -55176, 27224, 80366, 60444, 70285, -93898, -41133, 96576, -58266, 21711, -20614,
    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(25150);
        test.add(1412);
        test.add(82797);
        test.add(48381);
        test.add(7065);
        test.add(-47699);
        test.add(-25129);
        test.add(-65483);
        test.add(-64607);
        test.add(27224);
        test.add(80366);
        test.add(80366);
        test.add(60444);
        test.add(70285);
        test.add(-93898);
        System.out.println(solution.maxset(test));
    }

}
