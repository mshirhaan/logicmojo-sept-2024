class Solution {

    public int totalNQueens(int n) {
        int[] board = new int[n];
        return helper(board, 0);
    }

    public static int helper(int[] board, int row) {

        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (canIPlaceQueen(board, row, col)) { 
                board[row] = col;
                count+= helper(board, row + 1);
            }
        }
        return count;
    }

    public static boolean canIPlaceQueen(int[] board, int row, int col) {
        // check column above
        for (int i = 0; i < row; i++) {
            if (board[i] == col) {
                return false;
            }
        }
        // check left diagonal
        for (int i = 1; i < board.length; i++) {
            if (row - i < 0) {
                break;
            }
            if (board[row - i] == col - i) {
                return false;
            }
        }

        // check right diagonal
        for (int i = 1; i < board.length; i++) {
            if (row - i < 0) {
                break;
            }
            if (board[row - i] == col + i) {
                return false;
            }
        }

        return true;
    }

    public static List<String> generateBoard(int[] board) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < board.length; j++) {
                if (j == board[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());

        }
        return result;
    }
}
