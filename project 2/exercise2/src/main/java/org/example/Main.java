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

            if (!name.equals("dog") && !name.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }
            String petName = scanner.nextLine().trim(); // ввод имени питомца

            while (true) {
                try {
                    //boolean inputTrue = false;
                    int petAge = Integer.parseInt(scanner.nextLine().trim()); // ввод возраса

                    if (petAge <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        break;
                    } else {
                        double petWeight = Double.parseDouble(scanner.nextLine().trim()); // ввод веса питомца
                        if (petWeight <= 0) {
                            System.out.println("Incorrect input. Mass <= 0");
                            break;
                        } else if (name.equals("dog")) {
                            pets.add(new Dog(petName, petAge, petWeight));
                        } else {
                            pets.add(new Cat(petName, petAge, petWeight));
                        }
                        break;
                    }


                } catch (NumberFormatException exception) {
                    System.out.println("Could not parse a number. Please, try again");
                }
            }
        }

        for (Animal pet : pets) {
            System.out.println(pet);
        }
    }
}