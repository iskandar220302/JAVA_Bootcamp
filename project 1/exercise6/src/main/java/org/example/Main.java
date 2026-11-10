package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int size = scanner.nextInt();

                if (size <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                } else {
                    double[] array = new double[size];

                    for (int i = 0; i < size; i++) {
                        array[i] = scanner.nextDouble();
                    }

                    selectSort(array);

                    for (double v : array) {
                        System.out.print(v + " ");
                    }
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
            scanner.nextLine();
        }
    }

    public static void selectSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int  min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                double temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}