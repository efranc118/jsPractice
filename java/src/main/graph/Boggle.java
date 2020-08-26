package main;

import java.util.*;

public class Boggle {




    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> results = new ArrayList<>();

        for(String word: words) {
            boolean found = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    boolean[][] newMap = new boolean[board.length][board[i].length];
                    newMap[i][j] = true;
                    found = findWordHelper(newMap, board, "", i, j, word, 0);
                    if(found) {
                        results.add(word);
                        break;
                    }
                }
                if(found) break;
            }
        }

        return new ArrayList<>(results);
    }

    public boolean findWordHelper(boolean[][] map, char[][] board, String prefix,
                                       int curRow, int curCol, String word, int index) {
        if(board[curRow][curCol] != word.charAt(index)) return false;
        if(index == word.length() - 1) {
            return true;
        }

        boolean ret = false;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i == -1 && j == 0) || (i == 1 && j == 0) || (i == 0 && j == -1) || (i == 0 && j == 1)) {
                        int nextRow = curRow + i;
                        int nextCol = curCol + j;
                        if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) {
                            if (!map[nextRow][nextCol]) {
                                String nextPrefix = prefix + board[nextRow][nextCol];
                                map[curRow][curCol] = true;
                                ret = findWordHelper(map, board, nextPrefix, nextRow, nextCol, word, index + 1);
                                map[curRow][curCol] = false;
                                if(ret) break;
                            }
                        }
                    }
                }
                if(ret) break;
            }
        return ret;
    }

    //[["b","a","a","b","a","b"],["a","b","a","a","a","a"],["a","b","a","a","a","b"],["a","b","a","b","b","a"],["a","a","b","b","a","b"],["a","a","b","b","b","a"],["a","a","b","a","a","b"]]
    //["bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"]
    public static void main(String[] args) {
        Boggle solution = new Boggle();
        char[][] board = new char[][]{{'b','a','a','b','a','b'}, {'a','b','a','a','a','a'}, {'a','b','a','a','a','b'}
        , {'a','b','a','b','b','a'}, {'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'} };
        String[] words = new String[]{"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};

//        char[][] board = new char[][]{{'a','a'}};
//        String[] words = new String[]{"aa"};

        System.out.println(solution.findWords(board, words));
    }

}
