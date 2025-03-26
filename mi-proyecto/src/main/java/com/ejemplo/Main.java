package com.ejemplo;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        // Import products from the hardcoded CSV file
        Manager.importProductsFromCSV("mi-proyecto/src/main/java/com/ejemplo/Data.csv");

        scanner = new Scanner(System.in);
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("1. Buscar Producto por SKU");
            System.out.println("2. Ver todos los productos");
            System.out.println("3. Exit");
            System.out.print("Ingrese su opción: ");

            int choice = getValidIntInput();
            
            switch (choice) {
                case 1:
                    searchProductBySku();
                    break;
                case 2:
                    Manager.displayAllProducts();
                    break;
                case 3:
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchProductBySku() {
        System.out.print("Enter SKU to search: ");
        String sku = scanner.nextLine().trim();
        Manager.searchProductBySku(sku);
    }

    private static void exitApplication() {
        System.out.println("Exiting Product Management System...");
        scanner.close();
        System.exit(0);
    }

    private static int getValidIntInput() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                System.out.print("Ingrese su opción: ");
            }
        }
    }
}
