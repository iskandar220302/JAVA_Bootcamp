package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                int size = scanner.nextInt();

                if (size <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                } else {
                    int[] numbers = new int[size];
                    boolean numZnak = false;
                    int sum_numbers = 0, count_numbers = 0, result = 0;

                    for (int i = 0; i < size; i++) {
                        numbers[i] = scanner.nextInt();
                    }

                    for (int j = 0; j < size; j++) {
                        if (numbers[j] < 0) {
                            numZnak = true;
                        }
                    }

                    if (numZnak) {
                        for (int number : numbers) {
                            if (number < 0) {
                                sum_numbers += number;
                                count_numbers++;
                            }
                        }
                        result = sum_numbers / count_numbers;
                        System.out.println(result);
                        break;
                    } else {
                        System.out.println("There are no negative elements");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
            scanner.nextLine();
        } while (!check);
    }
}