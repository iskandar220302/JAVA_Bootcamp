package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    public static void main(String[] args) {
        int count = readInt();
        List<Animal> pets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String type = scanner.nextLine().trim();

            if (!type.equals("dog") && !type.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String name = scanner.nextLine().trim();
            int age = readInt();

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            if (type.equals("dog")) {
                pets.add(new Dog(name, age));
            } else {
                pets.add(new Cat(name, age));
            }
        }

        AnimalIterator iterator = new AnimalIterator(pets);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}