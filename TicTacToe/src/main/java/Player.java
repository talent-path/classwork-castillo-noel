public class Player {

    public static String playerName;

    public static String playerIcon;

    public static int numberOfVictories;

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Player.playerName = playerName;
    }

    public static String getPlayerIcon() {
        return playerIcon;
    }

    public static void setPlayerIcon(String playerIcon) {
        Player.playerIcon = playerIcon;
    }

    public static int getNumberOfVictories() {
        return numberOfVictories;
    }

    public static void setNumberOfVictories(int numberOfVictories) {
        Player.numberOfVictories = numberOfVictories;
    }
}
