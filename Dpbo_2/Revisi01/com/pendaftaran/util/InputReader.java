package com.pendaftaran.util;

import java.util.Scanner;

public class InputReader {

    public static String bacaString(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int bacaInt(String prompt, Scanner scanner, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("Input harus antara " + min + " hingga " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        }
    }
}
