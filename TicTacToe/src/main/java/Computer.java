public class Computer extends Player {

    // V A R I A B L E S
    public int difficultyLvl;


    // C O N S T R U C T O R S
    public Computer() {
        this.setPlayerName("Computer");
    }

    public Computer(Player player, int difficultyLvl) {
        this.setPlayerName("Computer");
        this.difficultyLvl = difficultyLvl;
    }

    // M E T H O D S


    public int getDifficultyLvl() {
        return difficultyLvl;
    }

    public void setDifficultyLvl(int difficultyLvl) {
        this.difficultyLvl = difficultyLvl;
    }
}
