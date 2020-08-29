package main.array;

public class RotateImage {


    public void rotate(int[][] matrix) {

        int min, max;
        min = 0;
        max= matrix.length - 1;

        while(min < max) {
            for(int i = min; i< max; i++) {
                int tmp = matrix[min][min + i];
                matrix[min][min + i] = matrix[max - i][min];
                matrix[max - i][min] = matrix[max][max - i];
                matrix[max][max - i] = matrix[min + i][max];
                matrix[min + i][max] = tmp;
            }
            min++;
            max--;
        }


    }

    /*

        int n = matrix.length;
    for (int i = 0; i < (n + 1) / 2; i ++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
        matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
        matrix[j][n - 1 - i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
     */

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] matrix = new int[][] {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},
        {33,1,20,7,21,7},{4,24,1,6,32,34}};
        System.out.println(matrix);
        solution.rotate(matrix);
        System.out.println(matrix);
    }

}
