package main;

public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] column: matrix) {
            if(searchRow(column, target)) return true;
        }

        return false;
    }

    public boolean searchRow(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(row[mid] == target) return true;
            if(row[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;

    }

    public static void main(String[] args) {
        SearchMatrix solution = new SearchMatrix();
        int[][] matrix = new int[][] {{1, 4,  7, 11, 15},{2, 5,  8, 12, 19}, {3,6,9,16,22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(solution.searchMatrix(matrix, 25));
    }

}
