import java.util.Scanner;

public class Console {

    public static long readLong(String msg, long min, long max) {
        long num = readLong(msg);

        while (num < min || num > max) {
            print("The entered long is outside the range of options, retry!");
            num = readLong(msg);
        }
        return num;
    }

    public static long readLong(String msg) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                print(msg);
                String userInput = input.nextLine();
                long parsedUserInput = Long.parseLong(userInput);
                return parsedUserInput;

            } catch (NumberFormatException nfe) {
                System.out.println("You entered invalid input, retry!");
            } finally {

            }
        }
    }

    public static float readFloat(String msg, float min, float max) {
        float num = readFloat(msg);

        while (num < min || num > max) {
            print("The entered float is outside the range of MIN and MAX, retry!");
            num = readFloat(msg);
        }
        return num;
    }

    public static float readFloat(String msg) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                print(msg);
                String userInput = input.nextLine();
                float parsedUserInput = Float.parseFloat(userInput);
                return parsedUserInput;

            } catch (NumberFormatException nfe) {
                System.out.println("You entered invalid input, retry!");
            } finally {

            }
        }
    }

    public static double readDouble(String msg, double min, double max) {
        double num = readDouble(msg);

        while (num < min || num > max) {
            print("The entered double is outside the range of MIN and MAX, retry!");
            num = readDouble(msg);
        }
        return num;
    }

    public static double readDouble(String msg) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                print(msg);
                String userInput = input.nextLine();
                double parsedUserInput = Double.parseDouble(userInput);
                return parsedUserInput;

            } catch (NumberFormatException nfe) {
                System.out.println("You entered invalid input, retry!");
            } finally {

            }
        }
    }

    public static int readInt(String msg, int min, int max) {
        int num = readInt(msg);

        while (num < min || num > max) {
            print("The entered integer is outside the range of MIN and MAX, retry!");
            num = readInt(msg);
        }
        return num;
    }

    public static int readInt(String msg) {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                print(msg);
                String userInput = input.nextLine();
                int parsedUserInput = Integer.parseInt(userInput);
                return parsedUserInput;

            } catch (NumberFormatException nfe) {
                System.out.println("You entered invalid input, retry!");
            } finally {

            }
        }
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static int min (int[] arr){

        int min = arr[0];
        for(int num: arr){
            if(num < min){
                min = num;
            }
        }

        return min;
    }

    public static int max (int[] arr) {

        int max = arr[0];
        for(int num: arr){
            if(num > max){
                max = num;
            }
        }

        return max;
    }

    public static double sum (int[] arr) {

        double sum = 0;
        for(int num: arr){
            sum += num;
        }

        return sum;
    }

    public static double avg (int[] arr){

        return sum(arr) / arr.length;
    }

    public static double stdv (int[] arr){

        double avg = avg(arr);
        double stdv = 0.0;
        for(double num: arr){
            stdv += Math.pow(num - avg, 2);
        }

        return Math.sqrt(stdv/arr.length);
    }

    public static int fibonacci(int n){

        int a = 0;
        int b = 1;
        int next = 0;

        if(n == 1){
            return a;
        } else if(n == 2){
            return b;
        } else {

            for (int i = 3; i <= n; i++) {
                next = a + b;
                a = b;
                b = next;
            }

            return next;
        }
    }

}
