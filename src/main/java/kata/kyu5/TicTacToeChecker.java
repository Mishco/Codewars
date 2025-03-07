package kata.kyu5;

public class TicTacToeChecker {

    private TicTacToeChecker() {
    }

    public static int isSolved(int[][] board) {
        // check two diagonals
        Integer boardDiagonal = checkDiagonals(board);
        if (boardDiagonal != null) return boardDiagonal;

        int totalSumRow = 0;
        int totalSumCol = 0;
        for (int row = 0; row < board.length; row++) {

            // check three columns
            int firstItem = board[row][0];
            int secondItem = board[row][1];
            int thirdItem = board[row][2];
            totalSumRow += firstItem + secondItem + thirdItem;

            if ((firstItem == secondItem) && (secondItem == thirdItem) && (thirdItem != 0)) {
                return firstItem;
            }

            // check three rows
            firstItem = board[0][row];
            secondItem = board[1][row];
            thirdItem = board[2][row];
            totalSumCol += firstItem + secondItem + thirdItem;

            if ((firstItem == secondItem) && (secondItem == thirdItem) && (thirdItem != 0)) {
                return firstItem;
            }
        }

        // Control if board is not yet finished -1
        if (totalSumRow <= 7 || totalSumCol <= 7) {
            return -1;
        }

        // Control if board is not yet finished -1
        if (totalSumRow <= 12 || totalSumCol <= 12) {
            return -1;
        }

        return 0;
    }

    /// Check two diagonals
    private static Integer checkDiagonals(int[][] board) {
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && board[0][0] != 0) {
            return board[0][0];
        }

        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && board[0][2] != 0) {
            return board[0][2];
        }
        return null;
    }
}
