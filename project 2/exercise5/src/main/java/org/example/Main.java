package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        long programStart = System.nanoTime();

        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int size = readNumber(scanner);

        readPets(scanner, pets, size, 0);

        CountDownLatch startSignal = new CountDownLatch(1);

        List<Thread> threads = pets.stream()
                .map(pet -> new Thread(() -> {
                    try {
                        startSignal.await();

                        double startTime =
                                (System.nanoTime() - programStart)
                                        / 1_000_000_000.0;

                        pet.goToWalk();

                        double endTime =
                                (System.nanoTime() - programStart)
                                        / 1_000_000_000.0;

                        synchronized (System.out) {
                            System.out.printf(
                                    Locale.US,
                                    "%s, start time = %.2f, end time = %.2f%n",
                                    pet,
                                    startTime,
                                    endTime
                            );
                        }

                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                    }
                }))
                .toList();

        threads.forEach(Thread::start);

        startSignal.countDown();

        threads.forEach(Main::joinThread);
    }

    private static int readNumber(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            System.out.println(
                    "Could not parse a number. Please, try again"
            );
            return readNumber(scanner);
        }
    }

    private static void readPets(
            Scanner scanner,
            List<Animal> pets,
            int size,
            int index
    ) {
        if (index >= size) {
            return;
        }

        String type = scanner.nextLine().trim();

        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println(
                    "Incorrect input. Unsupported pet type"
            );
            readPets(scanner, pets, size, index + 1);
            return;
        }

        String name = scanner.nextLine().trim();
        int age = readNumber(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            readPets(scanner, pets, size, index + 1);
            return;
        }

        if (type.equals("dog")) {
            pets.add(new Dog(name, age));
        } else {
            pets.add(new Cat(name, age));
        }

        readPets(scanner, pets, size, index + 1);
    }

    private static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}