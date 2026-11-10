package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                int size = scanner.nextInt();

                if (size <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                } else {
                    boolean numZnak = false;
                    int[] numbers = new int[size];
                    int[] IdenticalEdges = new int[size];
                    int place = 0; // координата для нового массива из нужных чисел

                    for (int i = 0; i < size; i++) {
                        numbers[i] = scanner.nextInt();
                    }

                    for (int j = 0; j < size; j++) {
                        if (FirstAndLastNumber(numbers[j])) {
                            IdenticalEdges[place] = numbers[j];
                            place++;
                            numZnak = true;
                        }
                    }

                    for (int i = 0; i < place; i++) {
                        System.out.print(IdenticalEdges[i] + " ");
                    }

                    if (numZnak == false) {
                        System.out.println("There are no such elements");
                    }

                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
            scanner.nextLine();
        }
    }

    private static boolean FirstAndLastNumber(int number) { // проверка что первая и последняя цифры одинаковы
        if  (number < 0) {
            number = Math.abs(number);
        }

        String text = String.valueOf(number);

        return text.charAt(0) == text.charAt(text.length() - 1);
    }
}