package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        int size;

        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine().trim());

                if (size < 0) {
                    System.out.println("Incorrect input. Please, try again");
                    continue;
                }

                break;
            } catch (NumberFormatException exception) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        for (int i = 0; i < size; i++) {
            String type = scanner.nextLine().trim();

            if (!type.equals("dog") && !type.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String petName = scanner.nextLine().trim();

            while (true) {
                try {
                    int petAge = Integer.parseInt(scanner.nextLine().trim());

                    if (petAge <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        break;
                    }

                    if (type.equals("dog")) {
                        pets.add(new Dog(petName, petAge));
                    } else {
                        pets.add(new Cat(petName, petAge));
                    }

                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("Could not parse a number. Please, try again");
                }
            }
        }

        for (Animal pet : pets) {
            System.out.println(pet);
        }

        scanner.close();
    }
}