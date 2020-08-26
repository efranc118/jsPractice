import java.util.ArrayList;

public class SpiralMatrix {


    public ArrayList<Integer> printSpiral(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix.size() == 0) return result;
        int dir, row,  col, minRow, maxRow, minCol, maxCol;
        dir = row = col = 0;
        minRow = 0;
        maxRow = matrix.size() - 1;
        minCol = 0;
        maxCol = matrix.get(0).size() - 1;

        while(minRow <= maxRow && minCol <= maxCol) {
            result.add(matrix.get(row).get(col));
            if(dir == 0) {
                if(col < maxCol) col++;
                else {
                    dir++;
                    row++;
                    minRow++;
                }
            }
            else if(dir == 1) {
                if(row < maxRow) row++;
                else {
                    dir++;
                    col--;
                    maxCol--;
                }
            }
            else if(dir == 2) {
                if(col > minCol) col--;
                else {
                    dir++;
                    row--;
                    maxRow--;
                }
            }
            else if(dir == 3) {
                if(row > minRow) row--;
                else {
                    dir = 0;
                    col++;
                    minCol++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for(int i = 0; i < 4; i++) {
            matrix.add(new ArrayList<>());
            for(int j = 0; j < 4; j++) {
                matrix.get(i).add(0);
                matrix.get(i).set(j, value++);
            }
        }

        solution.printSpiral(matrix);
    }

}
