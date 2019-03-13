package homeExercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String args[]) {

        createPerson();
        createPerson();
        Client.showClients();
    }

    private static void createPerson() {
        String name = "";
        String lastName = "";
        String phoneNUmber = "";
        String mailAddresCorrect = "";
        String mailLogin = "";
        System.out.println("What is your first and last name?");
        String fullName = scanner.nextLine();
        Pattern namePattern = Pattern.compile("(\\b[A-Z][a-z]+\\b) (\\b[A-Z][a-z]+\\b)");
        Matcher nameAndLastname = namePattern.matcher(fullName);
        if (nameAndLastname.find()) {
            name = nameAndLastname.group(1);
            lastName = nameAndLastname.group(2);

        } else {
            System.out.println("Wrong name, try again!");
            createPerson();
        }
        System.out.println("What is your email address?");
        String mailAddres = scanner.nextLine();
        Pattern mailPattern = Pattern.compile("(\\w+?.\\w+)@(\\w+).(\\w+)");
        Matcher mailMatcher = mailPattern.matcher(mailAddres);
        if (mailMatcher.find()) {
            mailAddresCorrect = mailMatcher.group();
            mailLogin = mailMatcher.group(1);
        } else {
            System.out.println("Wrong email, try again");
            createPerson();
        }
        System.out.println("What is your phone number?");
        String number = scanner.nextLine();
        Pattern phoneNumberPattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})");
        Matcher phoneMatcher = phoneNumberPattern.matcher(number);
        if (phoneMatcher.find()) {
            phoneNUmber = phoneMatcher.group(1) + "-" + phoneMatcher.group(2) + "-" + phoneMatcher.group(3);
        } else {
            System.out.println("wrong phone number, try again!");
            createPerson();

        }
        System.out.println("Your name: " + name + "\n" + "Your last name: " + lastName + "\n" + "Your phone number: " + phoneNUmber + "\n" + "Your mail address: " + mailAddresCorrect);
        Client client1 = new Client(name, lastName, phoneNUmber);
        Client.addClient(client1);

    }
}
