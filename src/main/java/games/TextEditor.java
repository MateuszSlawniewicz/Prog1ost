package games;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextEditor {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to text editor");
        mainEditorMenu();


    }

    private static void mainEditorMenu() {
        System.out.println("To create new file press 1");
        System.out.println("To edit file press 2");
        System.out.println("To end press 3");
        String decision = scanner.nextLine().trim();
        switch (decision) {
            case "1":
                String filePath = getFilePAth();
                createNewFile(filePath);
                mainEditorMenu();
                break;
            case "2":
                filePath = getFilePAth();
                allTextOperations(filePath);
                mainEditorMenu();
                break;
            case "3":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Wrong number!");
                mainEditorMenu();
                break;
        }
    }

    private static void allTextOperations(String filePath) {
        ArrayList<String> text = new ArrayList<>();
        try {
            text = readFile(filePath);
        } catch (IOException e) {
            System.out.println("There was been a mistake");
            System.out.println("Please try again");
        }
        textMenu();
        String menuAnswer = scanner.nextLine();
        textOperations(text, menuAnswer, filePath);
        toReturn(filePath, text);


    }

    private static void toReturn(String filePath, ArrayList<String> text) {
        System.out.println("Comeback to menu?");
        System.out.println("Yes or No");
        String decision = scanner.nextLine().trim().toUpperCase();
        switch (decision) {
            case "YES":
                allTextOperations(filePath);
                break;
            case "NO":
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Wrong answer");


        }
    }

    private static void saveChanges(String filePath, ArrayList<String> text) {
        PrintWriter toPrint = null;
        try {
            toPrint = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        for (String line : text) {
            toPrint.println(line);
        }
        toPrint.close();
    }

    private static void createNewFile(String filePath) {
        System.out.println("Write your test:");
        System.out.println("To end please write empty line");
        String text = scanner.nextLine().trim();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(text);
            System.out.println("File is created");
        } catch (IOException ex) {
            System.out.println("Error");
        }


    }


    private static void textOperations(ArrayList<String> text, String menuAnswer, String filePath) {
        ArrayList<String> toPrint = new ArrayList<>();
        switch (menuAnswer.trim()) {
            case "1":
                toPrint = (ArrayList<String>) text.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
                saveChanges(filePath, toPrint);
                System.out.println("save changes");
                break;
            case "2":
                toPrint = (ArrayList<String>) text.stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toList());
                saveChanges(filePath, toPrint);
                System.out.println("save changes");
                break;
            case "3":
                for (String lines : text) {
                    toPrint.addAll(Arrays.asList(lines.split(" ")));
                }
                saveChanges(filePath, toPrint);
                System.out.println("save changes");
                break;
            case "4":
                toPrint = (ArrayList<String>) text.stream()
                        .map(e -> e = e.concat("\n"))
                        .collect(Collectors.toList());
                saveChanges(filePath, toPrint);

                break;
            case "5":
                System.out.println(countWords(text));
                break;
            case "6":
                System.out.println(countLetters(text));
                break;
            case "7":
                System.out.println(countLines(text));
                break;
            default:
                System.out.println("Wrong number");
                break;
        }
    }

    private static int countLines(ArrayList<String> text) {
        return text.size();

    }

    private static int countLetters(ArrayList<String> text) {
        return text.stream()
                .mapToInt(e -> (e.length() - (e.split(" ").length) + 1))
                .sum();

    }

    private static int countWords(ArrayList<String> text) {
        return text.stream()
                .mapToInt(e -> e.split(" ").length)
                .sum();


    }

    private static void textMenu() {
        System.out.println("What would you like to do with text?");
        System.out.println("1. All in uppercase ");
        System.out.println("2. All in lowercase");
        System.out.println("3. Every word from the new line");
        System.out.println("4. Add extra spaces");
        System.out.println("5. Count words");
        System.out.println("6. Count letters");
        System.out.println("7. Count lines");
    }

    private static String getFilePAth() {
        System.out.println("Put file path");
        return scanner.nextLine();


    }

    public static ArrayList<String> readFile(String filePath) throws IOException {

        ArrayList<String> text = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String textLine = bufferedReader.readLine();
        do {
            text.add(textLine);

            textLine = bufferedReader.readLine();
        } while (textLine != null);

        bufferedReader.close();
        return text;
    }


    public static class RockPaperScissors {

        static String[] rockPaperScissors = {"Rock", "Paper", "Scissors"};
        static Random random = new Random();
        static Scanner scanner = new Scanner(System.in);
        static int[] result = {0, 0};

        public static void main(String[] args) {
            System.out.println("Welcome to Rock. Scissors and Paper");
            fullContest();


        }

        private static void fullContest() {
            game();
            System.out.println("Player:  " + result[0] + "\nComputer: " + result[1]);
            System.out.println("Round 2:");
            game();
            System.out.println("Player:  " + result[0] + "\nComputer: " + result[1]);
            System.out.println("Round 3:");
            game();
            System.out.println("Player:  " + result[0] + "\nComputer: " + result[1]);
            if (result[0] > result[1]) {
                System.out.println("You win");
            }
            if (result[0] < result[1]) {
                System.out.println("Computer win");
            } else {
                System.out.println("Tie");
            }
            checkIfEnd();
        }

        private static void checkIfEnd() {
            System.out.println("Play again or end?");
            System.out.println("1. Play again");
            System.out.println("2. End");
            String again = scanner.nextLine().trim();
            switch (again) {
                case "1":
                    fullContest();
                    break;
                case "2":
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Wrong number");
                    checkIfEnd();
                    break;
            }
        }

        private static void game() {

            String yourDecision = choosingWeapon();
            if (!yourDecision.equals("1") && !yourDecision.equals("2") && !yourDecision.equals("3")) {
                System.out.println("Wrong number");
                System.out.println("Try again!");
                game();
            }
            String computerTurn = rockPaperScissors[random.nextInt(3)];
            System.out.println(computerTurn);
            checkWhoWins(yourDecision, computerTurn);


        }

        private static void checkWhoWins(String yourDecision, String computerTurn) {
            if (computerTurn.equals("Rock")) {
                if (yourDecision.equals("1")) {
                    System.out.println("Tie");
                }
                if (yourDecision.equals("2")) {
                    System.out.println("Point for you");
                    result[0] = result[0] + 1;
                }
                if (yourDecision.equals("3")) {
                    System.out.println("Point for computer");
                    result[1] = result[1] + 1;
                }

            } else if (computerTurn.equals("Paper")) {
                if (yourDecision.equals("1")) {
                    System.out.println("Point for computer");
                    result[1] = result[1] + 1;
                }
                if (yourDecision.equals("2")) {
                    System.out.println("Tie");
                }
                if (yourDecision.equals("3")) {
                    System.out.println("Point for you");
                    result[0] = result[0] + 1;
                }
            } else {
                if (yourDecision.equals("1")) {
                    System.out.println("Point for you");
                    result[0] = result[0] + 1;
                }
                if (yourDecision.equals("2")) {
                    System.out.println("Point for computer");
                    result[1] = result[1] + 1;
                }
                if (yourDecision.equals("3")) {
                    System.out.println("Tie");
                }


            }
        }

        private static String choosingWeapon() {
            System.out.println("Chose your weapon");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            return scanner.nextLine().trim();
        }


    }
}
