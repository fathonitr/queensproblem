import java.util.Arrays;

public class Chessboard {
    public int[][] b;


    public Chessboard(int n) {

        b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = 0;
            }
        }
    }


    public boolean isSafe(int[][] board, int row, int col) {


        for (int i = 0; i < col; i++){    //check whether there is queen in the left or not
            if (board[row][i] == 1)
                return false;}
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 1)       //check whether there is queen in the left upper diagonal or not
                return false;}
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--){
            if (board[i][j] == 1)      //check whether there is queen in the left lower diagonal or not
                return false;}
        return true;
    }


    public boolean enumerate(int c, int n) {
        if (c >= n) {
            return true;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(b , row, c)) {
                b[row][c] = 1;
                if (enumerate(c + 1 , n)) {
                    return true ;
                } else  b[row][c] = 0;
            }

        }

        return false;
    }

    public void printQ(int n) {
        if (enumerate(0, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();

            }
            System.out.println();

        } else {
            System.out.println("No solution");
        }

    }
}

