package zoo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZooApp {
    public static final List<Animal> listOfAnimals = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome in Zoo");
        addExistingAnimalsToListAndShowThem();
        createAnimalAndAddToList();
        deleteAnimal();
    }

    private static void deleteAnimal() {
        String nameToDelete = setNameToDelete();
        deleteChosenAnimal(nameToDelete);
    }

    private static String setNameToDelete() {
        System.out.println("Set name to delete ");
        scanner.nextLine();
        return scanner.nextLine().toLowerCase();
    }

    private static void createAnimalAndAddToList() {
        showAnimalsToCreate();
        int chosenAnimal = scanner.nextInt();
        System.out.println("Set name : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Set age : ");
        int age = scanner.nextInt();
        Animal createdAnimal = createChosenAnimal(chosenAnimal, name, age);
        if (createdAnimal == null) return;
        addToListAndShow(createdAnimal);
    }

    private static void deleteChosenAnimal(String name) {
        listOfAnimals
                .stream()
                .filter(animal -> !animal.getName().toLowerCase().equals(name))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static Animal createChosenAnimal(int chosenAnimal, String name, int age) {
        Animal createdAnimal = null;
        if (chosenAnimal == 1) {
            createdAnimal = new Cat(name, age);
        } else if (chosenAnimal == 2) {
            createdAnimal = new Dog(name, age);
        } else if (chosenAnimal == 3) {
            createdAnimal = new Hamster(name, age);
        }
        if (createdAnimal == null) {
            System.out.println("Wrong number");
            return null;
        }
        return createdAnimal;
    }

    private static void addToListAndShow(Animal createdAnimal) {
        listOfAnimals.add(createdAnimal);
        listOfAnimals
                .stream()
                .forEach(System.out::println);
    }

    private static void showAnimalsToCreate() {
        System.out.println("Choose animal to add");
        System.out.println("1. Cat");
        System.out.println("2. Dog");
        System.out.println("3. Hamster");
    }

    private static void addExistingAnimalsToListAndShowThem() {
        Animal cat1 = new Cat("cat1", 2);
        Animal dog = new Dog("dog", 2);
        Animal dog2 = new Dog("dog2", 4);
        Animal cat2 = new Cat("Cat2", 5);
        Animal hamster = new Hamster("Hamster", 1);
        listOfAnimals.addAll(Arrays.asList(cat1, dog, dog2, cat2, hamster));
        listOfAnimals
                .stream()
                .forEach(System.out::println);
    }

}
