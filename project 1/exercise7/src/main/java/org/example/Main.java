package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = FileName();

        if (path == null) {
            System.out.println("Input error. File doesn't exist");
            return;
        }

        int mainSize = ReadSize(path);
        double[] numbers = ReadNumbers(path, mainSize);

        if (numbers == null) {
            return;
        }

        System.out.println(mainSize);

        for (int i = 0; i < mainSize; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        double minNum = FindMin(numbers);
        double maxNum = FindMax(numbers);

        CreateFile(minNum, maxNum);
    }

    public static Path FileName() {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();
        Path path = Path.of(fileName);

        if (Files.exists(path)) {
            return path;
        } else {
            return null;
        }
    }

    public static int ReadSize(Path path) throws IOException {
        Scanner fileScanner = new Scanner(path);
        int number = fileScanner.nextInt(); // сохранение количества чисел
        fileScanner.close();
        return number;
    }

    public static double[] ReadNumbers(Path path, int size) throws IOException {
        double[] numbersFiles = null;
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
            return null;
        }
        int count = 0;
        try(Scanner fileScanner = new Scanner(path)) {
            fileScanner.useLocale(Locale.US);

            fileScanner.nextInt(); // пропуск первого числа

            numbersFiles = new double[size];

            while (fileScanner.hasNext() && count < size) {
                if (fileScanner.hasNextDouble()) {
                    numbersFiles[count] = fileScanner.nextDouble();
                    count++;
                } else {
                    fileScanner.next();
                }
            }
        }

        if (count != size) {
            System.out.println("Input error. Insufficient number of elements");
            return null;
        }

        return numbersFiles;
    }

    public static double FindMin(double[] numbers) {
        double min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static double FindMax(double[] numbers) {
        double max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void CreateFile(double min, double max) {
        String fileName = "result.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(min + " " + max);
            System.out.println("Saving min and max values in file");
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
