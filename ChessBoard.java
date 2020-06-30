package eightqueens;


class ChessBoard {

    public void printPossibleSolution(int[] q) {

        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) {
                    System.out.print("Q ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public boolean isValid(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) {
                return false;
            }
            if ((q[i] - q[n]) == (n - i)) {
                return false;
            }
            if ((q[n] - q[i]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    public void solveTheBoard(int[] q, int k) {
        int n = q.length;
        if (k == n) {
            printPossibleSolution(q);
        }
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isValid(q, k)) solveTheBoard(q, k+1 );
            }
        }
    }

}

