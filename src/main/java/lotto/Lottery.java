package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Lottery {
    public static int[] randomValues = new int[6];
    public static int[] customerNumbers = new int[6];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();

    }

    private static void start() {
        beginGame();
        int actionType = scanner.nextInt();
        if (actionType == 1) {
            yourHappyNumber();
        } else if (actionType == 2) {
            classicLottery();
        } else if (actionType == 3) {
            System.out.println("End");
        } else {
            System.out.println("Wrong number");
        }
    }

    private static void beginGame() {
        System.out.println("Choose game : ");
        System.out.println("1. Your happy number");
        System.out.println("2. lotto");
        System.out.println("3. End");
    }

    private static void yourHappyNumber() {
        System.out.println("Choose one number from 1-20");
        int number = scanner.nextInt();
        if (number > 20 || number < 1) {
            System.out.println("Wrong number");
            start();
        }
        Random random = new Random();
        int randomValue = random.nextInt(20) + 1;
        if (randomValue == number) {
            System.out.println("You win");
        } else {
            System.out.println("You loose");
        }


        start();
    }

    private static void classicLottery() {
        createArrayOfCustomerNumbers();
        if (checkNumbers()) {
            createRandomValuesArray();
            checkLottery();
        } else {
            System.out.println("Check your numbers");
        }
        start();
    }

    private static void checkLottery() {
        Arrays.sort(randomValues);
        Arrays.sort(customerNumbers);
        int commonNumbers = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (customerNumbers[i] == randomValues[j]) {
                    commonNumbers++;
                }
            }
        }
        System.out.println(commonNumbers);
    }

    private static void createArrayOfCustomerNumbers() {
        System.out.println("Give 6 numbers, put spaces between");
        scanner.nextLine();
        String values = scanner.nextLine().trim();
        customerNumbers = Arrays.stream(values.split(" "))
                .mapToInt(number -> Integer.parseInt(number))
                .toArray();
        checkNumbers();

    }

    private static boolean checkNumbers() {
        boolean isTrue = true;
        for (int i = 0; i < 5; i++) {
            if (customerNumbers[i] == customerNumbers[i + 1]) {
                return false;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (customerNumbers[i] > 12) {
                return false;
            }
        }
        if (customerNumbers.length > 6) {
            return false;
        }
        return isTrue;
    }

    private static void createRandomValuesArray() {
        randomValues = new Random()
                .ints(1, 12)
                .distinct()
                .limit(6)
                .toArray();
        System.out.println(Arrays.toString(randomValues));
    }


}
