import java.util.Random;

public class Rng {

    // V A R I A B L E S
    static Random rng = new Random();

    // M E T H O D S
    public static int randomInt(int inclusiveMin, int inclusiveMax) {

        //this call takes an exclusive upper bound (or max)
        //returns a number between 0 and that bound - 1
        //rng.nextInt();

        return inclusiveMin + rng.nextInt(inclusiveMax - inclusiveMin + 1);
    }

    public static double readDouble(double incMin, double incMax) {
        return incMin + rng.nextDouble() * (incMax - incMin);
    }

    public static boolean coinFlip() {
        return rng.nextBoolean();
    }
}
