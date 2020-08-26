import java.util.ArrayList;

public class Pascal {


    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for(int i = 1; i <= A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) row.add(1);
                else row.add(triangle.get(i - 2).get(j - 1) + triangle.get(i - 2).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Pascal solution = new Pascal();
        System.out.println(solution.solve(3));
    }

}
