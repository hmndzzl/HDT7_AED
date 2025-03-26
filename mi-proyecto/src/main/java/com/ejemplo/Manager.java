package com.ejemplo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Manager {
    private static BinarySearchTree<Product> productTree = new BinarySearchTree<>();

    public static void importProductsFromCSV(String filePath) {
        // Clear existing tree before importing
        productTree = new BinarySearchTree<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header line
            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Ensure we have enough columns
                if (values.length >= 5) {
                    try {
                        Product product = new Product(
                            values[6],  // SKU
                            Double.parseDouble(values[9]),  // Price_Retail
                            Double.parseDouble(values[10]),  // Price_Current
                            values[18],  // Product_Name
                            values[0]   // Category
                        );
                        productTree.insert(product);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing product: " + line);
                    }
                }
            }
            System.out.println("Products imported successfully!");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public static void searchProductBySku(String sku) {
        Product searchProduct = new Product(sku, 0, 0, "", "");
        Product foundProduct = productTree.search(searchProduct);
        
        if (foundProduct != null) {
            System.out.println("Product Found:");
            System.out.println(foundProduct);
        } else {
            System.out.println("No product found with SKU: " + sku);
        }
    }

    public static void displayAllProducts() {
        // Use the inorder traversal to display all products
        List<Product> products = productTree.inorderTraversal();
        
        if (products.isEmpty()) {
            System.out.println("No products in the system.");
            return;
        }

        System.out.println("Total Products: " + products.size());
        System.out.println("----------------------------");
        
        for (Product product : products) {
            System.out.println(product);
            System.out.println("----------------------------");
        }
    }
}