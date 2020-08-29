package main.array;

public class StockRuns {

    public static int stock_runs(int[] prices) {

        int maxConsecutive = 0;
        int consecutive = 1;
        boolean isRising = true;
        int curVal = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if((prices[i] > curVal && true) ||
                    prices[i] < curVal && false) {
                consecutive++;
                if(consecutive > maxConsecutive) maxConsecutive = consecutive;
            }
            else {
                isRising = !isRising;
                consecutive = 2;
            }
            curVal = prices[i];
        }
        return maxConsecutive;
    }


    public static void main(String[] args) {
        StockRuns solution = new StockRuns();
        System.out.println(solution.stock_runs(new int[] { 2,3,4,3,2,1}));
    }

}
