package eightqueens;
public class Main {

    public static void main(String[] args){
        ChessBoard board = new ChessBoard();
        int[] a = new int[8];
        board.solveTheBoard(a, 0);
    }

}

