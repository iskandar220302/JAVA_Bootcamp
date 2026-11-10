package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = readInt(scanner);

        List<Animal> pets = readPets(scanner, size);

        pets.stream()
                .map(Main::growOlder)
                .forEach(System.out::println);
    }

    // Рекурсивно читает ровно size попыток ввода питомца.
    // Неудачная попытка (Optional.empty) тоже считается одной из size.
    private static List<Animal> readPets(Scanner scanner, int remaining) {
        if (remaining <= 0) {
            return List.of();
        }

        Optional<Animal> pet = readPet(scanner);
        List<Animal> rest = readPets(scanner, remaining - 1);

        return Stream.concat(pet.stream(), rest.stream()).toList();
    }

    // Читает одного питомца. При ошибке типа или возраста печатает сообщение
    // и возвращает Optional.empty(), не повторяя ввод.
    private static Optional<Animal> readPet(Scanner scanner) {
        String type = scanner.nextLine().trim().toLowerCase();

        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return Optional.empty();
        }

        String name = scanner.nextLine().trim();
        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return Optional.empty();
        }

        Animal pet = type.equals("dog") ? new Dog(name, age) : new Cat(name, age);
        return Optional.of(pet);
    }

    // Читает число; при ошибке парсинга сообщает и повторяет ввод рекурсивно.
    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse a number. Please, try again");
            return readInt(scanner);
        }
    }

    // Возвращает новый объект с возрастом +1 для питомцев старше 10 лет.
    private static Animal growOlder(Animal animal) {
        if (animal.getAge() <= 10) {
            return animal;
        }

        int newAge = animal.getAge() + 1;

        return animal instanceof Dog
                ? new Dog(animal.getName(), newAge)
                : new Cat(animal.getName(), newAge);
    }
}