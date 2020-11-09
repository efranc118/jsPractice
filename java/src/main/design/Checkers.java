package main.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Checkers {


    public class Board {
        private final Integer SIZE = 8;
        Piece[][] board;

        Board() {
            board = new Piece[SIZE][SIZE];
        }

        public void addListOfPieces(List<Piece> pieces) {
            if(validatePieces(pieces)) {
                for(Piece piece: pieces) {
                    board[piece.location.x][piece.location.y] = piece;
                }
            }
            else {
                throw new IllegalArgumentException("Invalid list of pieces");
            }
        }

        private boolean validatePieces(List<Piece> pieces) {
            HashSet<Location> locationHashSet = new HashSet<>();
            for(Piece piece: pieces) {
                if(checkBounds(piece.location)){
                    locationHashSet.add(piece.location);
                }
            }
            return locationHashSet.size() == pieces.size();
        }

        private boolean checkBounds(Location location) {
            return location.x >= 0 & location.x < SIZE && location.y >= 0 && location.y < SIZE;
        }

        public void move(Piece piece, Location destination) {

            // check current location is next to the destination location && inBounds
            // validate the destination is empty
            // perform the actual move by updating piece and the board(Both locations)
        if(validateMove(piece.location, destination)) {
            Location original = piece.location;
            piece.location = destination;
            board[destination.x][destination.y] = piece;
            board[original.x][original.y] = null;
        }
        else {
            throw new Error("Illegal move");
        }

        }


        /*
            Get the valid neighboring locations
            Check the destination location is open
            Check the intermediate location has a piece with the other Color
            Move the piece to destination
            Clear the current location
            Remove the intermediate piece from the board
         */
        public void jump(Piece piece, Location destination) {
            List<Location> jumpLocations = getJumpLocations(piece.location);
            if(!checkBounds(destination) || board[destination.x][destination.y] != null) throw new Error("Illegal jump arguments");
            Location current = piece.location;
            int unitX = destination.x - current.x / 2;
            int unitY = destination.y - current.y / 2;
            int midX = current.x + unitX;
            int midY = current.y + unitY;
            if(board[midX][midY] == null || board[midX][midY].color == piece.color) throw new Error("Illegal move arguments");

        }


        private boolean validateMove(Location original, Location destination) {
            //Find all neighboring locations
            //check bounds && if board is null at location
            List<Location> neighbors = getNeighboringLocations(original);
            for(Location location: neighbors) {
                if(location == destination) return true;
            }
            return false;

        }


        private List<Location> getNeighboringLocations(Location current) {
            Integer[][] movements = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

            HashSet<Location> possibleMoves = new HashSet<>();

            for(Integer[] move : movements) {
                Location next = new Location(current.x + move[0], current.y + move[1]);
                if(checkBounds(next) && board[next.x][next.y] == null) possibleMoves.add(next);
            }
            return new ArrayList<>(possibleMoves);
        }

        private List<Location> getJumpLocations(Location current) {
            Integer[][] movements = {{-2,-2},{-2,0},{-2,2},{0,-2},{0,2},{2,-2},{2,0},{2,2}};

            HashSet<Location> possibleMoves = new HashSet<>();

            for(Integer[] move : movements) {
                Location next = new Location(current.x + move[0], current.y + move[1]);
                if(checkBounds(next) && board[next.x][next.y] == null) possibleMoves.add(next);
            }
            return new ArrayList<>(possibleMoves);
        }


    }

    public class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public class Piece {
        COLOR color;
        Location location;
    }

    public enum COLOR{
        RED,
        BLACK
    }


    public static void main(String[] args) {
        Checkers solution = new Checkers();
//        System.out.println(solution.solve());
    }

}
