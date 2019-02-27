package ticTacToe;


import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String firstTab = "000\n000\n000";
    public static int[] checks = new int[9];

    public static void main(String[] args) {
        fillTheArray();
        int counter = 0;
        do {

            if (game()) {
                return;
            }
            counter++;
        } while (counter <= 4);
        System.out.println("The End");

    }

    private static void fillTheArray() {
        for (int i = 0; i < 9; i++) {
            checks[i] = i + 1;
        }
    }

    private static boolean game() {
        playerTurn();
        if (checkIfPlayerWin(firstTab) || checkIfComputerWin(firstTab)) {
            return true;
        }
        computerTurn();
        return checkIfPlayerWin(firstTab) || checkIfComputerWin(firstTab);

    }

    private static void computerTurn() {
        int indexValue;
        int placeOf2 = checks[indexValue = random.nextInt(checks.length)];
        if (placeOf2 == 0) {
            computerTurn();
        }
        checks[indexValue] = 0;
        firstTab = addTwo(firstTab, placeOf2);
        System.out.println(firstTab);
        System.out.println("-----------------------------");
    }

    private static String addTwo(String firstTab, int number) {

        String[] split = firstTab.split("\n");
        if (number <= 9 && number > 6) {
            number = number - 6;
            String[] strings = split[2].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "2";
                }
            }
            split[2] = String.join("", strings);
        } else if (number <= 6 && number > 3) {
            number = number - 3;
            String[] strings = split[1].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "2";
                }
            }
            split[1] = String.join("", strings);

        } else if (number <= 3) {
            String[] strings = split[0].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "2";
                }
            }
            split[0] = String.join("", strings);
        }
        return String.join("\n", split);


    }

    private static void playerTurn() {
        System.out.println("Choose number to place 1");
        System.out.println("number must be between 1 and 9");
        int placeOf1 = scanner.nextInt();
        if (placeOf1 < 1 || placeOf1 > 9) {
            System.out.println("Wrong number!");
            playerTurn();
        } else {
            if (checks[placeOf1 - 1] == 0) {
                System.out.println("Wrong number!");
                playerTurn();
            }
            checks[placeOf1 - 1] = 0;
            firstTab = addOne(firstTab, placeOf1);
            System.out.println(firstTab);
            System.out.println("-----------------------------");
        }
    }

    private static String addOne(String firstTab, int number) {
        String[] split = firstTab.split("\n");
        if (number <= 9 && number > 6) {
            number = number - 6;
            String[] strings = split[2].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "1";
                }
            }
            split[2] = String.join("", strings);
        } else if (number <= 6 && number > 3) {
            number = number - 3;
            String[] strings = split[1].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "1";
                }
            }
            split[1] = String.join("", strings);

        } else if (number <= 3) {
            String[] strings = split[0].split("");
            for (int i = 0; i < strings.length; i++) {
                if (i == number - 1) {
                    strings[i] = "1";
                }
            }
            split[0] = String.join("", strings);
        }
        return String.join("\n", split);


    }

    private static boolean checkIfPlayerWin(String firstTab) {

        String[] split = firstTab.split("\n");
        for (String s : split) {
            if (s.equals("111")) {
                System.out.println("Player win");
                return true;
            }

        }
        String toCheck = String.join("", split);

        if (("" + toCheck.charAt(0) + toCheck.charAt(3) + toCheck.charAt(6)).equals("111")) {
            System.out.println("Player win");
            return true;
        }
        if (("" + toCheck.charAt(1) + toCheck.charAt(4) + toCheck.charAt(7)).equals("111")) {
            System.out.println("Player win");
            return true;
        }
        if (("" + toCheck.charAt(2) + toCheck.charAt(5) + toCheck.charAt(8)).equals("111")) {
            System.out.println("Player win");
            return true;
        }
        if (("" + toCheck.charAt(0) + toCheck.charAt(4) + toCheck.charAt(8)).equals("111")) {
            System.out.println("Player win");
            return true;
        }
        if (("" + toCheck.charAt(2) + toCheck.charAt(4) + toCheck.charAt(6)).equals("111")) {
            System.out.println("Player win");
            return true;
        }
        return false;
    }

    private static boolean checkIfComputerWin(String firstTab) {

        String[] split = firstTab.split("\n");
        for (String s : split) {
            if (s.equals("222")) {
                System.out.println("Computer win");
                return true;
            }
        }
        String toCheck = String.join("", split);

        if (("" + toCheck.charAt(0) + toCheck.charAt(3) + toCheck.charAt(6)).equals("222")) {
            System.out.println("Computer win");
            return true;
        }
        if (("" + toCheck.charAt(1) + toCheck.charAt(4) + toCheck.charAt(7)).equals("222")) {
            System.out.println("Computer win");
            return true;
        }
        if (("" + toCheck.charAt(2) + toCheck.charAt(5) + toCheck.charAt(8)).equals("222")) {
            System.out.println("Computer win");
            return true;
        }
        if (("" + toCheck.charAt(0) + toCheck.charAt(4) + toCheck.charAt(8)).equals("222")) {
            System.out.println("Computer win");
            return true;
        }
        if (("" + toCheck.charAt(2) + toCheck.charAt(4) + toCheck.charAt(6)).equals("111")) {
            System.out.println("Computer win");
            return true;
        }
        return false;
    }
}
