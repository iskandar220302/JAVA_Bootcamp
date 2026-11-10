package org.example;

import java.util.Scanner;
import static org.example.Perimeter.perimeterOfTriangle;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try(Scanner console = new Scanner(System.in)) {
            boolean correctInput = false;

            while (!correctInput) {
                try {
                    double x1 = console.nextDouble();
                    double y1 = console.nextDouble();

                    double x2 = console.nextDouble();
                    double y2 = console.nextDouble();

                    double x3 = console.nextDouble();
                    double y3 = console.nextDouble();

                    boolean res1 = (x1 == x2 && y1 == y2);
                    boolean res2 = (x1 == x3 && y1 == y3);
                    boolean res3 = (x2 == x3 && y2 == y3);

                    if ((res1 || res2 || res3) ||
                            ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1) == 0)) {
                        System.out.println("Это не треугольник");
                    } else {
                        System.out.printf("%.3f%n", perimeterOfTriangle(x1, y1, x2, y2, x3, y3));
                    }

                    correctInput = true;

                } catch (InputMismatchException e) {
                    System.exit(-1);
                    System.err.println("Не удалось распознать число. Пожалуйста, попробуйте еще раз");
                } finally {
                    console.next();
                }
            }
        }
    }
}