import java.util.*;

public class App {

    public static void main(String[] args) {


    }

    public boolean checkRow(char[][] board, int row, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return true;
        }

        return false;
    }

    public boolean checkCol(char[][] board, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return true;
        }

        return false;
    }

    public boolean checkSquare(char[][] board, int row, int col, char num) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) return true;
            }
        }

        return false;

    }

    public void solveSudoku(char[][] board){

        boolean done = false;

        //1. loop through all the squares
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                //2. If the square is a '.', try each number one at a time
                if(board[row][col] == '.'){

                    for(char toTry = '1'; !done && toTry <= '9'; toTry++){
                       board[row][col] = toTry;
                       //3. Recursively check the board
                       if(sudokuValid(board)){
                           solveSudoku(board);
                           done = checkSolved(board);
                       }
                    }

                    //4. If we can't solve it after trying all numbers,
                    //      that means our earlier guess was bad, so we
                    //      need to give up here and let the recursion unwind.

                    if(!done){
                        board[row][col] = '.';

                        //now we're done because we tried everything
                        done = true;

                    }


                }
            }
        }
    }

    public boolean checkSolved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') return false;
            }
        }
        return true;
    }


    public boolean checkUnsolved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') return true;
            }
        }
        return false;
    }

    public boolean checkPlacement(int row, int col, char value, char[][] board) {
        char[][] boardCopy = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        if (boardCopy[row][col] == '.') {
            boardCopy[row][col] = value;
            if (sudokuValid(boardCopy)) {
                board[row][col] = value;
                return true;
            } else {
                board[row][col] = '.';
                return false;
            }
        }

        return false;
    }

    public static boolean placementValid(char[][] board, int row, int col) {

        List<Character> columns = new ArrayList<>();
        List<Character> rows = new ArrayList<>();
        List<Character> squares = new ArrayList<>();

        //Columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    if (columns.contains(board[j][i])) {
                        return false;
                    }
                    columns.add(board[j][i]);
                }
            }
            columns.clear();
        }

        //Rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }
            }
            rows.clear();
        }

        //Squares
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        } else {
                            if (squares.contains(board[i][j])) {
                                return false;
                            }
                            squares.add(board[i][j]);
                        }
                    }
                }
                squares.clear();
            }
        }

        return true;
    }

    public static boolean sudokuValid(char[][] board) {

        List<Character> columns = new ArrayList<>();
        List<Character> rows = new ArrayList<>();
        List<Character> squares = new ArrayList<>();

        //Columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    if (columns.contains(board[j][i])) {
                        return false;
                    }
                    columns.add(board[j][i]);
                }
            }
            columns.clear();
        }

        //Rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }
            }
            rows.clear();
        }

        //Squares
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        } else {
                            if (squares.contains(board[i][j])) {
                                return false;
                            }
                            squares.add(board[i][j]);
                        }
                    }
                }
                squares.clear();
            }
        }

        return true;
    }


    //6: 1 + 2 + 3 = 6
    //28: 1 + 2 + 4 + 7 + 14 = 28
//    public static boolean isPerfect(int num) {
//        if (num <= 0) return false;
//        int sumOfFactors = 0;
//
//        for (int factor = 1; factor <= num / factor; factor++) {
//            if (num % factor == 0) {
//                sumOfFactors += factor;
//                if (factor * factor != num) {
//                    sumOfFactors += num / factor;
//            }
//        }
//        return sumOfFactors - num == num ? true : false;
//    }


//        Map<Long, Integer> count = new HashMap<>();
//        int maxTerm = 0;
//        long maxNum = 0;
//
//        for (Long i = 1L; i < 1000000; i++) {
//            counter = 1;
//            longestCollatz(i);
//            count.put(i, counter);
//
//            if(counter > maxTerm){
//                maxNum = i;
//                maxTerm = counter;
//            }

//            Collections.max(count.values());
//


//        System.out.println("Starting # with longest chain under 1,000,000: " + maxNum);
//        System.out.println("Terms in the chain: " + maxTerm);


//    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        int counter = 0;
//        int maxLength = 0;
//        Map<Character, Integer> sMap = new HashMap<>();
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            counter++;
//            if (counter >= maxLength && !sMap.containsKey(s.charAt(i))) {
//                sMap.put(s.charAt(i), 1);
//                maxLength = sMap.keySet().size();
//
//            } else if ((counter < maxLength && !sMap.containsKey(s.charAt(i)))) {
//
//                sMap.put(s.charAt(i), 1);
//            } else {
//                counter = 0;
//                sMap.clear();
//            }
//        }
//
//
//        return maxLength;
//    }
//    public static int digitReverse(int toFlip) {
//        if (toFlip >= 0) {
//            return toFlip / 10 != 0 ? (int) (((toFlip % 10) * Math.pow(10, String.valueOf(toFlip).length() - 1)) + digitReverse(toFlip / 10))
//                    : toFlip;
//        } else {
//            return toFlip / 10 != 0 ? (int) (((toFlip % 10) * Math.pow(10, String.valueOf(toFlip).length() - 2)) + digitReverse(toFlip / 10))
//                    : toFlip;
//        }
//
//    }
//        int digitReverse = 0;
//        while(toFlip != 0){
//            int num = toFlip % 10;
//            digitReverse = (digitReverse * 10) + num;
//            toFlip /= 10;
//
//        }
//
//        return digitReverse;}

//    public static int longestCollatz(long n) {
//        if (n <= 1) {
//            return counter;
//        } else {
//            counter++;
//            return n % 2 == 0 ? longestCollatz(n/2) : longestCollatz((3 * n) + 1);
//        }
//    }

    //input ["Bob", "Bobby", "Robert", "Roberta", "Alice", "Alicia"
    //output:
    //      Map with 3 keys:
    //      "Bo" -> List: {"Bob", "Bobby"}
    //      "Ro" -> List: {"Robert", "Roberta"}
    //      "Al" -> List: {"Alice", "Alicia"}
//    public static Map<String, List<String>> groupByFirstTwoLetters(String[] toGroup) {
//
//        Map<String, List<String>> groupedNames = new HashMap<>();
//        for (String key : toGroup) {
//            if (!groupedNames.containsKey(key.substring(0, 2))) {
//                groupedNames.put(key.substring(0, 2), new ArrayList());
//            }
//            groupedNames.get(key.substring(0, 2)).add(key);
//        }
//
//        return groupedNames;
//    }
//
//    public static Map<String, List<String>> groupByFirstTwoLetters(String[] toGroup, int n) {
//
//        Map<String, List<String>> groupedNames = new HashMap<>();
//        for (String key : toGroup) {
//            if (!groupedNames.containsKey(key.substring(0, n))) {
//                groupedNames.put(key.substring(0, n), new ArrayList());
//            }
//            groupedNames.get(key.substring(0, n)).add(key);
//        }
//
//        return groupedNames;
//    }
//
//    public static int maxMirror(int[] arr) {
//        if (arr.length < 1) return 0;
//
//        int mirrorCounter = 0;
//        int maxMirror = 0;
//
//        for (int i = 0; i < arr.length - maxMirror; i++) {
//            for (int n = arr.length - 1; n >= 0; n--) {
//                mirrorCounter = 0;
//                if (arr[i] == arr[n]) {
//                    mirrorCounter = 1;
//                    for (int offset = 1; i + offset < arr.length && n - offset >= 0; offset++) {
//                        if (arr[i + offset] == arr[n - offset]) {
//                            mirrorCounter++;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (mirrorCounter > maxMirror) {
//                        maxMirror = mirrorCounter;
//                    }
//                }
//
//            }
//
//        }
//
//        return maxMirror;
//    }
//
//
//    //given two arrays of size 100 each representing a 100 digit number
//    //  (each element of the input array will have a value between 0 and 9
//    //return the 101-element "sum" of these two numbers
//    //  (in the output array, the digits should also be between 0 and 9
//    //the digit at index 0 is the one's place, index 1 is the 10's place and so on
//    public static int[] addBigNum(int[] left, int[] right) {
//
//        int[] sumOfArrs = new int[101];
//        int overflow = 0;
//
//        for (int i = 0; i < 100; i++) {
//            int temp = left[i] + right[i] + overflow;
//            overflow = 0;
//
//            //this is to account for the sum of 1s place flowing into the 10s place, and so on
//            while (temp > 10) {
//                overflow += 1;
//                temp -= 10;
//            }
//
//            sumOfArrs[i] = temp;
//            if (i == 99) {
//                sumOfArrs[i + 1] = overflow;
//            }
//        }
//
//        return sumOfArrs;
//    }
//
//    public static void printBigNum(int[] arrs) {
//        for (int i = arrs.length - 1; i >= 0; i--) {
//            System.out.print(arrs[i]);
//        }
//    }
}
