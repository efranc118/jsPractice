package main.design;

import java.util.Scanner;

class TicTacToe {

    int[][] board;
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if(checkRow(row, player) || checkCol(col, player) || checkDiagonals(player)) return player;
        return 0;
    }


    private boolean checkRow(int row, int val) {
        for(int i = 0; i < size; i++) {
            if(board[row][i] != val) return false;
        }
        return true;
    }

    private boolean checkCol(int col, int val) {
        for(int i =0; i < size; i++) {
            if(board[i][col] != val) return false;
        }
        return true;
    }

    private boolean checkDiagonals(int val) {
        int row = 0;
        int col = 0;
        boolean winner = true;
        while(row < size && col < size) {
            if(board[row][col] != val) {
                winner = false;
                break;
            };
            row++;
            col++;
        }
        if(winner) return true;
        row = 0;
        col = size - 1;
        while(row < size && col >= 0) {
            if(board[row][col] != val) return false;
            row++;
            col--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe solution = new TicTacToe(2);
        solution.move(0,1,1);
        solution.move(1,1,2);
        System.out.println(solution.move(1,0,1));


    }


}
