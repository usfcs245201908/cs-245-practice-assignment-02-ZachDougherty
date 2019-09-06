import java.util.*;

public class NQueens {
    private int[][] board;
    private int size;

    public NQueens(int n) {
        this.board = new int[n][n];
        this.size = n;
    }

    public boolean placeNQueens() throws Exception {
        if (this.board.length < 1) {
            throw new Exception();
        }
        return placeQueenRow(0);
    }

    private boolean placeQueenRow(int row) {
        // base case
        if (row >= this.size) {
            return true;
        }
        for (int i=0; i<this.size; i++) {
            if (this.isValid(row, i)) {
                this.board[row][i] = 1;
                if (this.placeQueenRow(row + 1) == true) {
                    return true;
                }
                // backtracking
                this.board[row][i] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        // since we are placing queens row by row, 
        // we need to check the portion of the 
        // column and diagnols above the 
        // placement row only for safety,
        // in other words we have to check spots 
        // where other queens have already been
        // placed.
        int i, j;
        // column
        for (i=0; i < row; i++) {
            if (this.board[i][col]==1) {
                return false;
            }
        }
        // positive diagonal
        for (i=row, j=col; i>=0 && j<this.size; i--, j++) {
            if (this.board[i][j] == 1) {
                return false;
            }
        }
        // negative diagonal
        for (i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (this.board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    
    public void printToConsole() {
        int i, j;
        System.out.println("\t ~ The Board ~\t\n");
        for (i=0; i<this.size; i++) {
            System.out.print("\t");
            for (j=0; j<this.size; j++) {
                if (this.board[i][j] == 1) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("_" + " ");
                }
            }
            System.out.println();
        }
    }
}