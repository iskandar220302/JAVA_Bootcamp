package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean flag = false;

        while (!flag) {
            try {
                num = scanner.nextInt();

                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
            }
        }

        try {
            if (num > 46 || num < -46) {
                throw  new StackOverflowError();
            } else {
                int res = Fibonacci(num);
                System.out.println(res);
            }
        } catch (StackOverflowError e) {
            System.out.println("Too large n");
        }

        scanner.close();
    }

    public static int Fibonacci(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            if (n < 0 && n >= -46) {
                int originalN = n;
                n *= -1;
                result = Fibonacci(n);

                if (n % 2 == 0) {
                    return -result;
                }

                return result;
            }
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}