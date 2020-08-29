package main.strings;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {


    List<String> wrapWords(String[] words, int lineLimit) {

        List<String> results = new ArrayList<>();
        StringBuilder nextLine = new StringBuilder();
        for(int i = 0; i< words.length; i++) {
            String nextString = words[i];
            if(nextLine.length() == 0) nextLine.append(nextString);
            else {
                if(nextLine.length() + nextString.length() + 1 > lineLimit) {
                    results.add(padLine(nextLine.toString(), lineLimit - nextLine.length()));
                    nextLine.delete(0, nextLine.length());
                    nextLine.append(nextString);
                } else {
                    nextLine.append("-" + nextString);
                }
            }
        }
        if(nextLine.length() > 0) results.add(lastLine(nextLine.toString(), lineLimit - nextLine.length()));

        return results;
    }

    String padLine(String nextLine, int remainingCount) {
        String[] split = nextLine.split("-");
        remainingCount += split.length - 1;
        if(split.length == 1) {
            for(int i = 0; i < remainingCount; i++) {
                split[0] += '-';
            }
        }
        else {
            for (int i = 0; i < remainingCount; i++) {
                int index = i % (split.length - 1);
                split[index]+="-";
            }
        }
        StringBuilder lastBuild = new StringBuilder();
        for(int i = 0; i < split.length; i++) {
            lastBuild.append(split[i]);
        }
        return lastBuild.toString();
    }

    String lastLine(String nextLine, int remainingCount) {
        if(nextLine.split("-").length < 2) return nextLine;
        return padLine(nextLine, remainingCount);
    }



    public static void main(String[] args) {
        WordWrap solution = new WordWrap();
        System.out.println(solution.wrapWords(new String[] {"it", "is", "a", "calm", "and", "quiet", "day"}, 10));
        System.out.println(solution.wrapWords(new String[] {"It", "is", "an", "easy", "and", "cool", "question"}, 10));
    }

}
