package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean errorWhile = true;
        boolean error = true;
        int pastNumber = 0;
        int index = 0;

        while (errorWhile) {
            if (scanner.hasNextInt()) {
                index++;
                int number = scanner.nextInt();

                if (number < pastNumber) {
                    System.out.println(
                            "The sequence is not ordered from the ordinal number of the number " + (index - 1));
                    break;
                }
                pastNumber = number;
            } else {
                error = false;
                errorWhile = false;
            }
        }

        if (!error && index > 0) {
            System.out.println("The sequence is ordered in ascending order");
        } else if (!errorWhile) {
            System.out.println("Input error");
        }

        scanner.close();
    }
}