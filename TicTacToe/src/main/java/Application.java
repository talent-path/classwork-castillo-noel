import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static String player1Icon;

    public static String player2Icon;

    public static String player1Name;

    public static String player2Name;

    public static boolean multiplayer;

    public static int player1Victories;

    public static int player2Victories;

    public static int numberOfMoves;

    public static int tieCount;

    public static int difficultyLvl;

    public static void main(String[] args) {

        String[][] board = clearBoard();
        playGame(board);

    }

    public static void playGame(String[][] board) {
        printRules();
        determineMultiplayer();
        enterNames();
        selectIcon();
        boolean player1Turn = true;
        boolean gameOver = false;
        boolean playAgain = true;
        Scanner scn = new Scanner((System.in));

        while (playAgain) {
            numberOfMoves = 0;
            while (!gameOver) {
                if (player1Turn) {
                    playerBoardPlacement(board, player1Icon, player1Name);
                    if (checkWinner(board)) {
                        gameOver = true;
                        player1Victories++;
                    }
                    player1Turn = !player1Turn;
                } else {
                    if (multiplayer) {
                        playerBoardPlacement(board, player2Icon, player2Name);
                    } else {
                        computerBoardPlacement(board, player2Icon, player2Name);
                    }
                    if (checkWinner(board)) {
                        gameOver = true;
                        player2Victories++;
                    }
                    player1Turn = !player1Turn;
                }

                numberOfMoves++;

                if (numberOfMoves == 9 && !gameOver) {
                    System.out.println("The game resulted in a tie!");
                    tieCount++;
                    gameOver = true;
                }
            }

            printScore();
            board = clearBoard();
            System.out.println("Enter 1 to play again, or any other key to exit: ");
            String playAgainSelection = scn.nextLine();
            if (!playAgainSelection.equals("1")) {
                playAgain = false;
            } else {
                gameOver = false;
            }

        }
        System.out.println("Thank you for playing Tic Tac Toe!");
    }

    public static void printRules() {
        System.out.println("Welcome to Play Tic Tac Toe!");
        System.out.println("The game is played on a grid that's 3 squares by 3 squares.\n" +
                "You can choose either X or O as your icon, with the opposing player defaulting to the unselected icon.\n" +
                "Players take turns putting their icon in empty squares.\n" +
                "The first player to get 3 of her/his icons in a row (up, down, across, or diagonally) is the winner.\n" +
                "When all 9 squares are full, the game is over.\n");
    }

    public static void printScore() {
        System.out.println(player1Name + " victories: " + player1Victories);
        System.out.println(player2Name + " victories: " + player2Victories);
        System.out.println("Ties: " + tieCount);
    }

    public static void printBoard(String[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static String[][] clearBoard() {

        String[][] board = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        return board;

    }

    public static void playerBoardPlacement(String[][] board, String playerIcon, String playerName) {

        boolean movePlaced = false;
        Scanner scn = new Scanner(System.in);

        while (!movePlaced) {
            System.out.println("Your move " + playerName + ". Select a position from the board above by entering the number displayed in the slot: ");
            printBoard(board);
            String userSelection = scn.nextLine();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (userSelection.equals(board[row][col])) {
                        board[row][col] = playerIcon;
                        movePlaced = true;
                        return;
                    }
                }
            }
            System.out.println("That is not a valid selection!");
        }

    }

    public static void computerBoardPlacement(String[][] board, String playerIcon, String playerName) {

        boolean movePlaced = false;
        System.out.println(playerName + " has placed a move.");

        //Easy Mode
        if (difficultyLvl == 1) {
            while (!movePlaced) {
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (!player1Icon.equals(board[row][col]) && !player2Icon.equals(board[row][col])) {
                            if (Rng.coinFlip() && Rng.coinFlip()) {
                                board[row][col] = playerIcon;
                                movePlaced = true;
                                return;
                            }
                        }
                    }
                }
            }
        }

        //Moderate Mode
        if (difficultyLvl == 2) {
            while (!movePlaced) {
                if (numberOfMoves == 0) {
                    board[0][0] = playerIcon;
                    movePlaced = true;
                    return;
                } else if (numberOfMoves == 1) {
                    if (board[1][1] == player1Icon) {
                        board[0][0] = playerIcon;
                        movePlaced = true;
                        return;
                    } else {
                        board[1][1] = playerIcon;
                        movePlaced = true;
                        return;
                    }
                } else {
                    while (!movePlaced) {
                        for (int row = 0; row < board.length; row++) {
                            for (int col = 0; col < board[row].length; col++) {
                                if (!player1Icon.equals(board[row][col]) && !player2Icon.equals(board[row][col])) {
                                    if (Rng.coinFlip() && Rng.coinFlip()) {
                                        board[row][col] = playerIcon;
                                        movePlaced = true;
                                        return;
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

        //Hard Mode
        if (difficultyLvl == 3) {
            while (!movePlaced) {
                if (numberOfMoves == 0) {
                    board[0][0] = playerIcon;
                    movePlaced = true;
                    return;
                } else if (numberOfMoves == 1) {
                    if (board[1][1] == player1Icon) {
                        board[0][0] = playerIcon;
                        movePlaced = true;
                        return;
                    } else {
                        board[1][1] = playerIcon;
                        movePlaced = true;
                        return;
                    }
                } else {
                    while (!movePlaced) {
                        for (int row = 0; row < board.length; row++) {
                            for (int col = 0; col < board[row].length; col++) {
                                if (!player1Icon.equals(board[row][col]) && !player2Icon.equals(board[row][col])) {
                                    if (Rng.coinFlip() && Rng.coinFlip()) {
                                        board[row][col] = playerIcon;
                                        movePlaced = true;
                                        return;
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

    }

    public static void selectIcon() {
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println(player1Name + " enter X or O for your icon selection:");
            player1Icon = scn.nextLine().toUpperCase(Locale.ROOT);
            if (player1Icon.equals("X")) {
                player2Icon = "O";
                return;
            } else if (player1Icon.equals("O")) {
                player2Icon = "X";
                return;
            } else {
                System.out.println("That is not a valid entry!");
            }
        }
    }

    public static void enterNames() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Player 1 please enter your name:");
        player1Name = scn.nextLine();
        if (multiplayer) {
            System.out.println("Player 2 please enter your name:");
            player2Name = scn.nextLine();
        } else {
            player2Name = "Computer";
        }
    }

    public static void determineMultiplayer() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter 1 for Multiplayer or any other key to face the Computer:");
        String multiplayerInput = scn.nextLine();
        if (multiplayerInput.equals("1")) {
            multiplayer = true;
        } else {
            difficultyLvl = Console.readInt("Enter the given number to select difficulty\n1: Easy\n2: Moderate\n3: Hard", 1, 3);
        }
    }

    public static boolean checkWinner(String[][] board) {

        //There are 8 winning conditions
        //Horizontal wins:
        if (board[0][0].equals(player1Icon) && board[0][1].equals(player1Icon) && board[0][2].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }
        if (board[1][0].equals(player1Icon) && board[1][1].equals(player1Icon) && board[1][2].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }
        if (board[2][0].equals(player1Icon) && board[2][1].equals(player1Icon) && board[2][2].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }

        if (board[0][0].equals(player2Icon) && board[0][1].equals(player2Icon) && board[0][2].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }
        if (board[1][0].equals(player2Icon) && board[1][1].equals(player2Icon) && board[1][2].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }
        if (board[2][0].equals(player2Icon) && board[2][1].equals(player2Icon) && board[2][2].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }

        //Vertical wins:
        if (board[0][0].equals(player1Icon) && board[1][0].equals(player1Icon) && board[2][0].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }
        if (board[0][1].equals(player1Icon) && board[1][1].equals(player1Icon) && board[2][1].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }
        if (board[0][2].equals(player1Icon) && board[1][2].equals(player1Icon) && board[2][2].equals(player1Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }

        if (board[0][0].equals(player2Icon) && board[1][0].equals(player2Icon) && board[2][0].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }
        if (board[0][1].equals(player2Icon) && board[1][1].equals(player2Icon) && board[2][1].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }
        if (board[0][2].equals(player2Icon) && board[1][2].equals(player2Icon) && board[2][2].equals(player2Icon)) {
            System.out.println(player2Name + "Won!");
            return true;
        }

        //Diagonal wins:
        if (board[0][0].equals(player1Icon) && board[1][1].equals(player1Icon) && board[2][2].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }
        if (board[0][2].equals(player1Icon) && board[1][1].equals(player1Icon) && board[2][0].equals(player1Icon)) {
            System.out.println(player1Name + " Won!");
            return true;
        }

        if (board[0][0].equals(player2Icon) && board[1][1].equals(player2Icon) && board[2][2].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }
        if (board[0][2].equals(player2Icon) && board[1][1].equals(player2Icon) && board[2][0].equals(player2Icon)) {
            System.out.println(player2Name + " Won!");
            return true;
        }

        return false;
    }
}
