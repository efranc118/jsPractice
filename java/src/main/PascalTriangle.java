
import java.util.*;

public class PascalTriangle {

    Map<Tuple, Integer> memoizeMap = new HashMap<>();

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(getCell(rowIndex, i));
        }
        return result;
    }

    public Integer getCell(int row, int column) {
        Tuple key = new Tuple(row, column);
        if(memoizeMap.containsKey(key)) return memoizeMap.get(key);
        if(row == 0 || column == 0 || row == column) {
            memoizeMap.put(key, 1);
            return 1;
        }
         Integer result = getCell(row - 1, column - 1) + getCell(row - 1, column);
        memoizeMap.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        System.out.println(solution.getRow(33));
    }

}

class Tuple {
    public final Integer x;
    public final Integer y;
    public Tuple(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Objects.equals(x, tuple.x) &&
                Objects.equals(y, tuple.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
