package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {                                                              //____________________|
    public static List<String> filter(List<String> strings, String substring) { // filter(List, "oo")__|
        List<String> result = new ArrayList<>();                               //\_______________/|\___|
                                                                              //__\_________то что ищем|
        for (String str : strings) {                                         //\\__\/\/\/\/\/\/\/\/\/\/|
            if (str.contains(substring)) {                                  //__\\__\/\/\/\/\/\/\/\/\/\|
                result.add(str);                                           //____\\__\/\/\/\/\/\/\/\/\/|
            }                                                             //______\\__\/\/\/\/\/\/\/\/\|
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            strings.add(scanner.nextLine());
        }

        String substring = scanner.nextLine();

        List<String> result = filter(strings, substring);

        System.out.println(String.join(", ", result));

        scanner.close();
    }
}

