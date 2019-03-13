package games;

;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Hangman {
    static String[] words = {"pies", "kot", "motyl", "krowa", "szczur", "ryba", "wieloryb", "rekin", "mysz", "robak"};
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int mistakes = 0;
    public static String show = "";

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman");
        String word = words[random.nextInt(words.length)];
        StringBuilder str = new StringBuilder();
        IntStream.range(0, word.length()).forEach(value -> str.append("0"));
        System.out.println("You word is " + str.toString());
        show = str.toString();
        game(word, show);

    }

    private static void game(String word, String toResult) {
        System.out.println("Put your letter ");
        String letter = scanner.nextLine().trim().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        if (word.contains(letter)) {
            String str = checkIsContain(word, letter, stringBuilder);
            createNewStringToShow(toResult, str);
            System.out.println(show);
            if (!show.contains("0")) {
                System.out.println("You win");
            } else {
                game(word, show);
            }

        } else {
            mistakes++;
            drawing(mistakes, word, show);
        }
    }

    private static String checkIsContain(String word, String letter, StringBuilder stringBuilder) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                stringBuilder.append(letter);
            } else {
                stringBuilder.append(show.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static void createNewStringToShow(String toResult, String str) {
        StringBuilder strbuilder = new StringBuilder();
        for (int i = 0; i < toResult.length(); i++) {
            if (toResult.charAt(i) == str.charAt(i)) {
                strbuilder.append(toResult.charAt(i));
            } else {
                strbuilder.append(str.charAt(i));
            }
        }
        show = strbuilder.toString();
    }

    private static void drawing(int points, String word, String toResult) {
        if (points == 0) {
            System.out.println("");
            game(word, toResult);
        }
        if (points == 1) {
            elevenPoint();
            game(word, toResult);
        }
        if (points == 2) {
            tenPoint();
            game(word, toResult);
        }
        if (points == 3) {
            ninePoint();
            game(word, toResult);
        }
        if (points == 4) {
            eigthPoint();
            game(word, toResult);
        }
        if (points == 5) {
            sixPoints();
            game(word, toResult);
        }
        if (points == 6) {
            fivePoints();
            game(word, toResult);
        }
        if (points == 7) {
            fourPoints();
            game(word, toResult);
        }
        if (points == 8) {
            threePoints();
            game(word, toResult);
        }
        if (points == 9) {
            twoPoints();
            game(word, toResult);
        }
        if (points == 10) {
            onePoint();
            game(word, toResult);
        }
        if (points == 11) {
            lastStand();
        }

    }

    private static void elevenPoint() {
        System.out.println("|");
    }

    private static void tenPoint() {
        elevenPoint();
        elevenPoint();
    }

    private static void ninePoint() {
        tenPoint();
        elevenPoint();
    }

    private static void eigthPoint() {
        System.out.println(" _");
        ninePoint();
    }

    private static void sixPoints() {
        System.out.print(" _");
        eigthPoint();
    }

    private static void fivePoints() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        ninePoint();
    }

    private static void fourPoints() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        System.out.println("|   /");
        elevenPoint();
        System.out.println("| ");
    }

    private static void threePoints() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        System.out.println("|   /\\");
        elevenPoint();
        System.out.println("| ");
    }

    private static void twoPoints() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        System.out.println("|   /|\\");
        elevenPoint();
        System.out.println("| ");
    }

    private static void onePoint() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        System.out.println("|   /|\\");
        System.out.println("|    /");
        System.out.println("| ");
    }

    private static void lastStand() {
        System.out.print(" _");
        System.out.print(" _");
        System.out.println(" o");
        System.out.println("|   /|\\");
        System.out.println("|    /\\");
        System.out.println("| ");
        System.out.println("GAME OVER");
    }

}
