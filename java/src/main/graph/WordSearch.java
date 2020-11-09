package main.graph;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];


        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                StringBuilder builder = new StringBuilder();
                if(findWord(board, visited, word, builder.append(board[i][j]), i, j)) return true;
            }
        }
        return false;
    }


    public boolean findWord(char[][] board, boolean[][] visited, String target, StringBuilder current, int row, int col) {
        if(current.toString().equals(target)) return true;
        if(current.length() >= target.length()) return false;

        int[][] directions = {{-1, 0},{0,1},{1,0},{0,-1}};
        int pos = current.length();
        for(int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(checkBounds(nextRow, nextCol, visited) && !visited[nextRow][nextCol] && board[nextRow][nextCol] == target.charAt(pos)) {
                visited[nextRow][nextCol] = true;
                current.append(board[nextRow][nextCol]);
                if(findWord(board, visited, target, current, nextRow, nextCol)) return true;
                visited[nextRow][nextCol] = false;
                current.deleteCharAt(current.length() - 1);
            }
        }
        return false;

    }


    public boolean checkBounds(int row, int col, boolean[][] visited) {
        if(row >= 0 && row < visited.length && col >= 0 && col < visited[0].length) return true;
        return false;
    }



    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] map = new char[][]   {{'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}};
        System.out.println(solution.exist(map, "ABCCED"));
    }

}
