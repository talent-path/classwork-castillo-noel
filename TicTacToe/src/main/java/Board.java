public class Board {

    // V A R I A B L E S
    public static String[][] board;

    // M E T H O D S
    public static void printBoard() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static String[][] clearBoard() {

        board = new String[][] {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        return board;

    }

    public static String[][] getBoard() {
        return board;
    }

    public static void setBoard(String[][] board) {
        Board.board = board;
    }
}
