package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sec = Input();
        String res = Calc(sec);
        Output(res);
    }

    public static int Input() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean flag = false;

        do {
            try {
                number = scanner.nextInt();
                if (number < 0) {
                    System.out.println("Incorrect time");
                } else {
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
            }
        } while (!flag);
        scanner.close();
        return number;
    }

    public static String Calc(int seconds) {
        int hours = seconds / 3600;
        int minutes = seconds % 3600 / 60; //3599 / 60 = 59
        int second = seconds % 60; //3599 % 60 = 59

        return String.format("%02d:%02d:%02d", hours, minutes, second);
    }

    private static void Output(String formattedTime) {
        System.out.println(formattedTime);
    }
}