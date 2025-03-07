package kata.kyu5;

public class TicTacToeChecker {

    public static int isSolved(int[][] board) {
        // check two diagonals
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
            return board[0][0];
        }

        // check two diagonals
        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
            return board[0][2];
        }

        int total_sum_row = 0;
        int total_sum_col = 0;
        for (int row = 0; row < board.length; row++) {

            // check three columns
            int first_item = board[row][0];
            int second_item = board[row][1];
            int third_item = board[row][2];
            total_sum_row += first_item + second_item + third_item;

            if ((first_item == second_item) && (second_item == third_item) && (third_item != 0)) {
                return first_item;
            }

            // check three rows
            first_item = board[0][row];
            second_item = board[1][row];
            third_item = board[2][row];
            total_sum_col += first_item + second_item + third_item;

            if ((first_item == second_item) && (second_item == third_item) && (third_item != 0)) {
                return first_item;
            }
        }

        // Control if board is not yet finished -1
        if (total_sum_row <= 7 || total_sum_col <= 7) {
            return -1;
        }

        // Control if board is not yet finished -1
        if (total_sum_row <= 12 || total_sum_col <= 12) {
            return -1;
        }

        return 0;
    }
}
