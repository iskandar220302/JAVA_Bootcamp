package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        int size = 0;
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine().trim());
                if (size < 0) {
                    System.out.println("Incorrect input. Unsupported pet type");
                    continue;
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
        for (int i = 0; i < size; i++) {
            String name = scanner.nextLine().trim(); // ввод вида

            if (!name.equals("dog") && !name.equals("cat")
                    && !name.equals("hamster") && !name.equals("guinea")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }
            String petName = scanner.nextLine().trim(); // ввод имени питомца
            while (true) {
                try {
                    int petAge = Integer.parseInt(scanner.nextLine().trim()); // ввод возраса
                    if (petAge <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        break;
                    } else if (name.equals("dog")) {
                        pets.add(new Dog(petName, petAge));
                    } else if (name.equals("cat")) {
                        pets.add(new Cat(petName, petAge));
                    } else if (name.equals("hamster")) {
                        pets.add(new Hamster(petName, petAge));
                    } else {
                        pets.add(new GuineaPig(petName, petAge));
                    }
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("Could not parse a number. Please, try again");
                }
            }
        }
        for (Animal pet : pets) {
            if (pet instanceof Herbivore) {
                System.out.println(pet);
            }
        }
        for (Animal pet : pets) {
            if (pet instanceof Omnivore) {
                System.out.println(pet);
            }
        }
    }
}