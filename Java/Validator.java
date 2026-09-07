/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gudanginternet;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
public class Validator {

    private Validator() {
    }

    public static int inputInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka bulat.");
            }
        }
    }

    public static int inputIntMin(Scanner sc, String prompt, int min) {
        while (true) {
            int value = inputInt(sc, prompt);
            if (value < min) {
                System.out.println("Nilai tidak boleh kurang dari " + min);
                continue;
            }
            return value;
        }
    }

    public static double inputDoubleMin(Scanner sc, String prompt, double min) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < min) {
                    System.out.println("Nilai tidak boleh kurang dari " + min);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
            }
        }
    }

    public static String inputString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue;
            }
            return input;
        }
    }

    public static int inputPilihanMenu(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int pilihan = inputInt(sc, prompt);
            if (pilihan < min || pilihan > max) {
                System.out.println("Pilihan harus antara " + min + " - " + max);
                continue;
            }
            return pilihan;
        }
    }
}
