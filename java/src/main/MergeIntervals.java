import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();
        Stack<Interval> stack = new Stack<>();
        ArrayList<Interval> sortedList = new ArrayList<>();
        if(intervals.size() < 1) {
            result.add(newInterval);
            return result;
        }
        boolean merged = false;
        for(int i = 0; i < intervals.size(); i++) {
            if(!merged && newInterval.start < intervals.get(i).start) {
                sortedList.add(newInterval);
                merged = true;
            }
            sortedList.add(intervals.get(i));
        }
        if(!merged) sortedList.add(newInterval);

        stack.push(sortedList.get(0));
        for(int i = 1; i < sortedList.size(); i++) {
            Interval current = stack.pop();
            Interval next = sortedList.get(i);
            if(next.start > current.end) {
                result.add(current);
                current = next;
            }
            else {
                current.end = Math.max(next.end, current.end);
            }
            stack.push(current);
        }
            result.add(stack.pop());
        printIntervals(result);
        return result;


    }




    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparing(a-> a.start));
        Interval current = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if(current.end < next.start) {
                result.add(current);
                current = next;
            }   else {
                current.end = Math.max(current.end, next.end);
                current.start = Math.min(current.start, next.start);
            }
        }

        result.add(current);
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        ArrayList<Interval> input = new ArrayList<>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,6));
        System.out.println(solution.merge(input));
    }


    private void printIntervals(ArrayList<Interval> intervals) {
        for(int i = 0 ; i < intervals.size(); i++) {
            System.out.print(intervals.get(i).start + " " + intervals.get(i).end + "\n");
        }
    }

}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
