package main;

public class SubSequenceSums {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(k > calories.length) return 0;
        int currentTotal = 0;
        int totalPoints = 0;
        for(int i = 0; i < k; i++) {
            currentTotal += calories[i];
        }
        if(currentTotal < lower) totalPoints--;
        if(currentTotal > upper) totalPoints++;
        for(int i = k; i< calories.length; i++) {
            currentTotal += calories[i];
            currentTotal -= calories[i - k];
            if(currentTotal < lower) totalPoints--;
            if(currentTotal > upper) totalPoints++;
        }

        return totalPoints;
    }


    public static void main(String[] args) {
        SubSequenceSums solution = new SubSequenceSums();
        System.out.println(solution.dietPlanPerformance(new int[] {6,13,8,7,10,1,12,11},
        6,
        5,
        37));
    }

}
