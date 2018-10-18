package RecursivePractice;

public class EightQueens {
    public static final int SIZE = 8;


    public static void printBoard (int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");

            }
            System.out.println();
        }
    }

    boolean isSafe(int[][] board, int row, int col) {
        int i = 0, j = 0;

        for (i = 0; i < col; i++){
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i>=0 && j>=0; i--,j--){
            if (board[i][j]==1){
                return false;
            }
        }

        for (i = row, j = col; j>=0 && i<SIZE; i++, j--){
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    boolean solve(int[][] board, int col){
        if (col >= SIZE) {
            return true; //return true if nothing left to solve
        }

        for (int i = 0; i < SIZE; i++) {
            if (isSafe(board, i, col)){
                board[i][col] = 1;
                if (solve(board,col+1) == true){
                    return true;                        //  Recursive to place the rest of the queen
                }
                board[i][col] = 0; // Backtrack
            }

        }

        return false;
    }

    boolean solve(){
        int[][] board = new int[SIZE][SIZE];

        if (solve(board,0) == false) {
            System.out.println("Invalid solution");
            return false;

        }
        printBoard(board);
        return true;
    }

    public static void main(String[] args) {
        EightQueens problem = new EightQueens();
        problem.solve();
    }
}
