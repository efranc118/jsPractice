package main.dynamic;

public class MaximalRectangle {

        public int maximalRectangle(char[][] matrix) {
            if(matrix.length < 1) return 0;
            int maxCount = 0;
            int[][] colCounts = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {

                        colCounts[i][j] = j > 0 ? colCounts[i][j-1] + 1 : 1;

                        int minWidth = matrix[i][j];
                        int currentCount = 0;
                        for (int k = i; k >= 0; k--) {
                            minWidth = Math.min(minWidth, colCounts[k][j]);
                            currentCount = minWidth * (i - k + 1);
                            if (currentCount > maxCount) maxCount = currentCount;
                        }
                    }
                }
            }

            return maxCount;
        }


    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();
        char[][] rectangle = new char[][] {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle(rectangle));
    }

}
