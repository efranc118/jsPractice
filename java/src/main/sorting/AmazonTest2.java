package main.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonTest2 {

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        Collections.sort(logLines, (l1, l2) -> {
            String[] line1 = l1.split(" ", 2);
            String[] line2 = l2.split(" ", 2);
            boolean isDigit1 = isDigit(line1[1]);
            boolean isDigit2 = isDigit(line2[1]);
            if(!isDigit1 && !isDigit2) {
                int stringComparison = line1[1].compareTo(line2[1]);
                if(stringComparison != 0) return stringComparison;
                return line1[0].compareTo(line2[0]);
            }
            if(isDigit1) return 1;
            return -1;
            });
        return logLines;
    }

    public boolean isDigit(String line) {
        return Character.isDigit(line.charAt(0));
    }


    public static void main(String[] args) {
        AmazonTest2 solution = new AmazonTest2();
        ArrayList<String> logs = new ArrayList<>();
        logs.add("a1 9 2 3 1");
        logs.add("g1 act car");
        logs.add("zo4 4 7");
        logs.add("ab1 off key dog");
        logs.add("a8 act zoo");
        System.out.println(solution.reorderLines(5, logs));
    }

}
