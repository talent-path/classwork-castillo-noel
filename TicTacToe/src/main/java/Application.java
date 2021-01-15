import java.util.Scanner;

public class Application {

    public static boolean multiplayer;

    public static int numberOfMoves;

    public static int difficultyLvl;

    public static void main(String[] args) {

        Board board = new Board();
        Player player1 = new Player();
        Player player2 = new Player();
        board.clearBoard();
        playGame(board, player1, player2);

    }

    public static void playGame(Board board, Player player1, Player player2) {
        printRules();
        determineMultiplayer();

        System.out.println("Player 1 please enter your name:");
        player1 = enterName(player1);

        if (multiplayer) {
            System.out.println("Player 2 please enter your name:");
            player2 = enterName(player2);
        } else {
            player2.setPlayerName("Computer");
        }


        player1 = selectIcon(player1);
        if(player1.getPlayerIcon().equals("X")){
            player2.setPlayerIcon("O");
        } else{
            player2.setPlayerIcon("X");
        }

        boolean player1Turn = true;
        boolean gameOver = false;
        boolean playAgain = true;
        Scanner scn = new Scanner((System.in));

        while (playAgain) {
            numberOfMoves = 0;
            while (!gameOver) {
                if (player1Turn) {
                    playerBoardPlacement(board, player1);
                    if (checkWinner(board, player1, player2)) {
                        gameOver = true;
                        player1.setNumberOfVictories(player1.getNumberOfVictories() + 1);
                        player2.setNumberOfLosses(player2.getNumberOfLosses() + 1);
                    }
                    player1Turn = !player1Turn;
                } else {
                    if (multiplayer) {
                        playerBoardPlacement(board, player2);
                    } else {
                        computerBoardPlacement(board, player2, player1);
                    }
                    if (checkWinner(board, player1, player2)) {
                        gameOver = true;
                        player2.setNumberOfVictories(player2.getNumberOfVictories() + 1);
                        player1.setNumberOfLosses(player1.getNumberOfLosses() + 1);
                        System.out.println(player2.getNumberOfVictories());
                    }
                    player1Turn = !player1Turn;
                }

                numberOfMoves++;

                if (numberOfMoves == 9 && !gameOver) {
                    System.out.println("The game resulted in a tie!");
                    player1.setNumberOfTies(player1.getNumberOfTies() + 1);
                    player2.setNumberOfTies(player2.getNumberOfTies() + 1);
                    gameOver = true;
                }
            }

            player1.printScore();
            player2.printScore();

            board.clearBoard();
            int playAgainSelection = Console.readInt("Enter 1 to play again, or 2 to exit: ", 1, 2);
            if (playAgainSelection == 1) {
                playAgain = true;
                gameOver = false;
            } else {
                playAgain = false;
            }

        }
        System.out.println("Thank you for playing Tic Tac Toe " + player1.getPlayerName() + " and " + player2.getPlayerName() + "!");
    }

    public static void printRules() {
        System.out.println("Welcome to Play Tic Tac Toe!");
        System.out.println("The game is played on a grid that's 3 squares by 3 squares.\n" +
                "You can choose either X or O as your icon, with the opposing player defaulting to the unselected icon.\n" +
                "Players take turns putting their icon in empty squares.\n" +
                "The first player to get 3 of her/his icons in a row (up, down, across, or diagonally) is the winner.\n" +
                "When all 9 squares are full, the game is over.\n");
    }


    public static void playerBoardPlacement(Board board, Player player) {

        boolean movePlaced = false;
        Scanner scn = new Scanner(System.in);

        while (!movePlaced) {
            System.out.println("Your move " + player.getPlayerName() + ". Select a position from the board above by entering the number displayed in the slot: ");
            board.printBoard();
            String userSelection = scn.nextLine();
            for (int row = 0; row < board.getBoard().length; row++) {
                for (int col = 0; col < board.getBoard()[row].length; col++) {
                    if (userSelection.equals(board.getBoard()[row][col])) {
                        board.getBoard()[row][col] = player.getPlayerIcon();
                        movePlaced = true;
                        return;
                    }
                }
            }
            System.out.println("That is not a valid selection!");
        }

    }

    public static void computerBoardPlacement(Board board, Player computer, Player player) {

        boolean movePlaced = false;
        System.out.println(computer.getPlayerName() + " has placed a move.");

        //Easy Mode
        if (difficultyLvl == 1) {
            while (!movePlaced) {
                for (int row = 0; row < board.getBoard().length; row++) {
                    for (int col = 0; col < board.getBoard()[row].length; col++) {
                        if (!player.getPlayerIcon().equals((board.getBoard()[row][col])) && !computer.getPlayerIcon().equals((board.getBoard()[row][col]))) {
                            if (Rng.coinFlip() && Rng.coinFlip()) {
                                board.getBoard()[row][col] = computer.getPlayerIcon();
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
                    board.getBoard()[0][0] = computer.getPlayerIcon();
                    movePlaced = true;
                    return;
                } else if (numberOfMoves == 1) {
                    if (board.getBoard()[1][1] == player.getPlayerIcon()) {
                        board.getBoard()[0][0] = computer.getPlayerIcon();
                        movePlaced = true;
                        return;
                    } else {
                        board.getBoard()[1][1] = computer.getPlayerIcon();
                        movePlaced = true;
                        return;
                    }
                } else {
                    while (!movePlaced) {
                        for (int row = 0; row < board.getBoard().length; row++) {
                            for (int col = 0; col < board.getBoard()[row].length; col++) {
                                if (!player.getPlayerIcon().equals((board.getBoard()[row][col])) && !computer.getPlayerIcon().equals((board.getBoard()[row][col]))) {
                                    if (Rng.coinFlip() && Rng.coinFlip()) {
                                        board.getBoard()[row][col] = computer.getPlayerIcon();
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
                    board.getBoard()[0][0] = computer.getPlayerIcon();
                    movePlaced = true;
                    return;
                } else if (numberOfMoves == 1) {
                    if (board.getBoard()[1][1] == player.getPlayerIcon()) {
                        board.getBoard()[0][0] = computer.getPlayerIcon();
                        movePlaced = true;
                        return;
                    } else {
                        board.getBoard()[1][1] = computer.getPlayerIcon();
                        movePlaced = true;
                        return;
                    }
                } else {
                    while (!movePlaced) {
                        for (int row = 0; row < board.getBoard().length; row++) {
                            for (int col = 0; col < board.getBoard()[row].length; col++) {
                                if (!player.getPlayerIcon().equals((board.getBoard()[row][col])) && !computer.getPlayerIcon().equals((board.getBoard()[row][col]))) {
                                    if (Rng.coinFlip() && Rng.coinFlip()) {
                                        board.getBoard()[row][col] = computer.getPlayerIcon();
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

    public static Player selectIcon(Player player) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println(player.getPlayerName() + " enter X or O for your icon selection:");
            String iconSelection = scn.nextLine().toUpperCase();
            if (iconSelection.equals("X") || iconSelection.equals("O")) {
                player.setPlayerIcon(iconSelection);
                return player;
            }
            System.out.println("That is not a valid entry!");
        }
    }

    public static Player enterName(Player player) {
        Scanner scn = new Scanner(System.in);
        String playerNameInput = scn.nextLine();
        player.setPlayerName(playerNameInput);
        return player;
    }

    public static void determineMultiplayer() {
        Scanner scn = new Scanner(System.in);

        int multiplayerInput = Console.readInt("Enter 1 for Multiplayer or 2 to face the Computer:", 1, 2);
        if (multiplayerInput == 1) {
            multiplayer = true;
        } else {
            difficultyLvl = Console.readInt("Enter the given number to select difficulty\n1: Easy\n2: Moderate\n3: Hard", 1, 3);
        }
    }

    public static boolean checkWinner(Board board, Player player1, Player player2) {

        //There are 8 winning conditions
        //Horizontal wins:
        if (board.getBoard()[0][0].equals(player1.getPlayerIcon()) && board.getBoard()[0][1].equals(player1.getPlayerIcon()) && board.getBoard()[0][2].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[1][0].equals(player1.getPlayerIcon()) && board.getBoard()[1][1].equals(player1.getPlayerIcon()) && board.getBoard()[1][2].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[2][0].equals(player1.getPlayerIcon()) && board.getBoard()[2][1].equals(player1.getPlayerIcon()) && board.getBoard()[2][2].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }

        if (board.getBoard()[0][0].equals(player2.getPlayerIcon()) && board.getBoard()[0][1].equals(player2.getPlayerIcon()) && board.getBoard()[0][2].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[1][0].equals(player2.getPlayerIcon()) && board.getBoard()[1][1].equals(player2.getPlayerIcon()) && board.getBoard()[1][2].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[2][0].equals(player2.getPlayerIcon()) && board.getBoard()[2][1].equals(player2.getPlayerIcon()) && board.getBoard()[2][2].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }

        //Vertical wins:
        if (board.getBoard()[0][0].equals(player1.getPlayerIcon()) && board.getBoard()[1][0].equals(player1.getPlayerIcon()) && board.getBoard()[2][0].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][1].equals(player1.getPlayerIcon()) && board.getBoard()[1][1].equals(player1.getPlayerIcon()) && board.getBoard()[2][1].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][2].equals(player1.getPlayerIcon()) && board.getBoard()[1][2].equals(player1.getPlayerIcon()) && board.getBoard()[2][2].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }

        if (board.getBoard()[0][0].equals(player2.getPlayerIcon()) && board.getBoard()[1][0].equals(player2.getPlayerIcon()) && board.getBoard()[2][0].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][1].equals(player2.getPlayerIcon()) && board.getBoard()[1][1].equals(player2.getPlayerIcon()) && board.getBoard()[2][1].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][2].equals(player2.getPlayerIcon()) && board.getBoard()[1][2].equals(player2.getPlayerIcon()) && board.getBoard()[2][2].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + "Won!");
            return true;
        }

        //Diagonal wins:
        if (board.getBoard()[0][0].equals(player1.getPlayerIcon()) && board.getBoard()[1][1].equals(player1.getPlayerIcon()) && board.getBoard()[2][2].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][2].equals(player1.getPlayerIcon()) && board.getBoard()[1][1].equals(player1.getPlayerIcon()) && board.getBoard()[2][0].equals(player1.getPlayerIcon())) {
            System.out.println(player1.getPlayerName() + " Won!");
            return true;
        }

        if (board.getBoard()[0][0].equals(player2.getPlayerIcon()) && board.getBoard()[1][1].equals(player2.getPlayerIcon()) && board.getBoard()[2][2].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }
        if (board.getBoard()[0][2].equals(player2.getPlayerIcon()) && board.getBoard()[1][1].equals(player2.getPlayerIcon()) && board.getBoard()[2][0].equals(player2.getPlayerIcon())) {
            System.out.println(player2.getPlayerName() + " Won!");
            return true;
        }

        return false;
    }
}
