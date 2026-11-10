package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int quantity = scanner.nextInt();
                List<User> users = new ArrayList<>();

                for (int i = 0; i < quantity; i++) {
                    String name = scanner.next();
                    int age = scanner.nextInt();

                    if (age <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        i--;
                        continue;
                    }

                    User user = new User(name, age);
                    users.add(user);
                }
                String result = users.stream()
                        .filter(user -> user.getAge() >= 18)
                        .map(user -> user.getName())
                        .collect(Collectors.joining(", "));

                System.out.println(result);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }
}