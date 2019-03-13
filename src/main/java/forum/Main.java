package forum;


import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static User user;
    public static UserService userService = new UserService();
    private static final Scanner scanner = new Scanner(System.in);
    public static TopicService topicService = new TopicService();

    public static void main(String[] args) {
        initialMenu();
        start();


    }

    private static void start() {
        if (user == null) {
            initialMenu();
        } else {
            loggedMenu();
        }

    }

    private static void loggedMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Add a new topic");
        System.out.println("2. Add a new post");
        System.out.println("3. Search for a interesting topic");
        System.out.println("4. Read posts in topic");
        System.out.println("5. Remove topic");
        System.out.println("6. Remove post");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                createNewTopic();
                break;
            case "2":
                addANewPost();
                break;
            case "3":
                createListOfTopics();
                break;
            case "4":
                showPostsAndTopics();
                break;
            case "5":
                removeTopic();
                break;
            case "6":
                removePost();
                break;
            default:
        }
        start();


    }

    private static void removePost() {
        initiationOfListToChooseATopic("Find topic where is your post");
        String topicName = scanner.nextLine().trim();
        topicService.showWithNumber(topicName);
        System.out.println("Choose post id number");
        String numberOfPost = scanner.nextLine().trim();
        Optional<Topic> topic = Optional.of(topicService.getTopics().stream()
                .filter(e -> e.getName().equals(topicName))
                .findAny()
                .get());
        if (!topic.isPresent()) {
            System.out.println("Wrong topic");
            removePost();
        } else {
            topic.get().removePostFromTopic(numberOfPost);
        }


    }

    private static void initiationOfListToChooseATopic(String s) {
        System.out.println(s);
        createListOfTopics();
        System.out.println("Write topic name");

    }

    private static void removeTopic() {
        initiationOfListToChooseATopic("Choose topic to delete");
        String topicName = scanner.nextLine().trim();
        topicService.removeTopic(topicName);
        start();
    }

    private static void showPostsAndTopics() {
        initiationOfListToChooseATopic("Find interesting topic");
        String topicName = scanner.nextLine().trim();
        topicService.show(topicName);

    }

    private static void createListOfTopics() {
        if (topicService.getTopics().size() == 0) {
            System.out.println("List is empty");
        } else {
            topicService.getTopics().stream()
                    .map(Topic::getName)
                    .forEach(System.out::println);
        }

    }

    private static void addANewPost() {
        initiationOfListToChooseATopic("Chose name of topic");
        String decision = scanner.nextLine().trim();
        Optional<Topic> topic = Optional.ofNullable(topicService.getTopics().stream()
                .filter(e -> e.getName().equals(decision))
                .findAny()
                .orElse(null));
        if (!topic.isPresent()) {
            System.out.println("Topic not found");
        } else {
            System.out.println("Write your text");
            String text = scanner.nextLine();
            Post post = new Post(text, topic.get());
            System.out.println("Post added");
        }
        start();
    }

    private static void createNewTopic() {
        System.out.println("Add topic name:");
        String name = scanner.nextLine();
        System.out.println("Add first post:");
        String text = scanner.nextLine();
        Topic topic = new Topic(name);
        new Post(text, topic);
        topicService.addATopic(topic);


    }

    private static void initialMenu() {
        System.out.println("Welcome in our forum");
        System.out.println("1. To create a new account");
        System.out.println("2. To login");
        String decision = scanner.nextLine().trim();
        switch (decision) {
            case "1":
                registration();
                break;
            case "2":
                login();
                break;
            default:
                System.out.println("Wrong number, try again");
                initialMenu();

        }
        start();


    }

    private static void login() {
        System.out.println("------LOGIN-------");
        System.out.println("your name: ");
        String name = scanner.nextLine().trim();
        System.out.println("your password: ");
        String password = scanner.nextLine().trim();
        boolean ifSucces = userService.login(name, password);
        if (ifSucces) {
            System.out.println("Welcome");
        } else {
            System.out.println("Error, try again!");
            login();
        }
    }

    private static void registration() {
        System.out.println("-----REGISTRATION------");
        System.out.println("your name: ");
        String name = scanner.nextLine().trim();
        String email = emailSolution();
        String password = passwordSolution();
        boolean ifSucces = userService.registration(name, password, email);
        if (ifSucces) {
            System.out.println("Registration is done");
        } else {
            System.out.println("Error");
            registration();
        }
    }

    private static String passwordSolution() {
        System.out.println("plese enter your password, there must be a 8 letters, without numbers");
        String password = scanner.nextLine();
        if (password.length() < 8) {
            System.out.println("Wrong password");
            passwordSolution();
        }
        Pattern passwordPatter = Pattern.compile("\\D{8,}");
        Matcher passwordMatcher = passwordPatter.matcher(password);
        if (passwordMatcher.find()) {
        } else {
            System.out.println("Wrong password");
            passwordSolution();
        }
        return password;
    }

    private static String emailSolution() {
        System.out.println("your email addres");
        String email = scanner.nextLine().trim();
        Pattern mailPattern = Pattern.compile("(\\w+?.\\w+)@(\\w+).(\\w+)");
        Matcher mailMatcher = mailPattern.matcher(email);
        if (mailMatcher.find()) {
        } else {
            System.out.println("Wrong email, try again");
            emailSolution();
        }
        return email;
    }

}
