package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Battleship {


    public static void main(String[] args) {
        Battleship solution = new Battleship();

    }

}

//class Game {
//    Player player1;
//    Player player2;
//    Board board1;
//    Board board2;
//    final static Integer ROWS = 7;
//    final static Integer COLS = 7;
//
//    Game(Player player1, Player player2){
//        this.player1 = player1;
//        this.player2 = player2;
//        board1 = new Board();
//        board2 = new Board();
//    }
//
//    void createPlayerOne() {
//        //Create Player 1
//    }
//
//    void createPlayerTwo() {
//        //Create Player 2
//    }
//
//    void setShips(Board board) {
////        int[] lengths = new int[] {2,3,4,4,5};
////        Scanner input = new Scanner(System.in);
////        for(int length: lengths) {
////            Coordinate startingCoordinate;
////            Ship ship;
////            do {
////                System.out.println("Select the starting coordinate row[A - G] for ship of length " + length);
////                String row = input.next().toLowerCase();
////                System.out.println("Select the starting coordinate col[1 - 8] for ship of length " + length);
////                Integer col = input.nextInt();
//////                startingCoordinate = new Coordinate(row.charAt(0), col);
////            } while(!startingCoordinate.isValidCoordinate());
////
////            System.out.println("Select the direction for the remaining ship length[Up, Down, Left, Right]");
////            String dir = input.next();
//////            board.ships[i] = new Ship(startingCoordinate, dir, length);
////        }
//
//    }
//
////    void takeTurn {
////        //
////    }
//
//
//
//}

//
//class Player {
//    String name;
//    Color  color;
//}
//
// enum Color {
//    RED,
//    BLUE
//}
//
//enum Direction {
//    UP,
//    DOWN,
//    LEFT,
//    RIGHT
//}
//
//class Coordinate {
//    Integer row;
//    Integer col;
//
//    static Map<Character, Integer> rowMap;
//
//    static {
//        rowMap = new HashMap<Character, Integer>() {};
//        rowMap.put('a', 1);
//        rowMap.put('b', 2);
//        rowMap.put('c', 3);
//        rowMap.put('d', 4);
//        rowMap.put('e', 5);
//        rowMap.put('f', 6);
//        rowMap.put('g', 7);
//    }
//
//    Coordinate(Character row, Integer col) {
//        this.row = rowMap.get(row);
//        this.col = col;
//    }
//
//    Coordinate(int row, int col) {
//        this.row = row;
//        this.col = col;
//    }
//
//    boolean isValidCoordinate() {
//        if(col < 1 || col > 8) return false;
//        int val = row - 'a';
//        return val >= 0 && val <= 7;
//    }
//
//    static int getRow(Character row) {
//        return rowMap.get(row);
//    }
//}
//
//
//class Ship {
//    int length;
//    boolean sunk;
//    Coordinate[] coordinates;
//
//    Ship(Coordinate startingCoordinate, Direction direction, int length) {
//        if(isValidPosition(startingCoordinate, direction, length)) {
//           setCoordinates(startingCoordinate, direction, length);
//        }
//    }
//
//    void setCoordinates(Coordinate startingCoordinate, Direction direction, int length) {
//        if(isValidPosition(startingCoordinate, direction, length)) {
//            coordinates = new Coordinate[length];
//            coordinates[0] = startingCoordinate;
//            for(int i = 1; i < length; i++) {
//                if(direction == Direction.UP) coordinates[i] = new Coordinate(startingCoordinate.row - i,
//                        startingCoordinate.col);
//                if(direction == Direction.RIGHT) coordinates[i] = new Coordinate(startingCoordinate.row,
//                        startingCoordinate.col + i);
//                if(direction == Direction.DOWN) coordinates[i] = new Coordinate(startingCoordinate.row + i,
//                        startingCoordinate.col);
//                if(direction == Direction.LEFT) coordinates[i] = new Coordinate(startingCoordinate.row,
//                        startingCoordinate.col - i);
//            }
//        }
//    }
//
//    boolean isValidPosition(Coordinate startingCoordinate, Direction direction, int length) {
//
//    }
//
//}
//
//class Board {
//    boolean[][] guesses;
//    Ship[] ships;
//
//    Board(Integer rows, Integer cols, Ship[] ships) {
//        this.guesses = new boolean[rows][cols];
//        this.ships = ships;
//    }
//

//}


