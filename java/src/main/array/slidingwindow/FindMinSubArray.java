package main.array.slidingwindow;

public class FindMinSubArray {

    public int findMinSubArray(int S, int[] arr) {
        int subArrayLength = 1;
        while(subArrayLength < arr.length) {
            int curSum = 0;
            for(int i = 0; i < subArrayLength; i++) {
                curSum += arr[i];
            }
            int ptr = subArrayLength;
            if(curSum >= S) return subArrayLength;
            while(ptr < arr.length) {
                curSum -= arr[ptr - subArrayLength];
                curSum += arr[ptr];
                if(curSum >= S) return subArrayLength;
                ptr++;
            }
            subArrayLength++;
        }
        return -1;
    }


    public static void main(String[] args) {
        FindMinSubArray solution = new FindMinSubArray();
//        System.out.println(solution.findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));
        System.out.println(solution.findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));
//        System.out.println(solution.findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
    }

}
