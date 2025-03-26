/**
 * Clase Product que representa un producto con atributos como SKU, precio, nombre y categoría.
 */
package com.ejemplo;
import java.util.Objects;

public class Product implements Comparable<Product> {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String productName;
    private String category;

    /**
     * Constructor para crear un nuevo producto.
     * 
     * @param sku SKU del producto.
     * @param priceRetail Precio de venta al público del producto.
     * @param priceCurrent Precio actual del producto.
     * @param productName Nombre del producto.
     * @param category Categoría del producto.
     */
    public Product(String sku, double priceRetail, double priceCurrent, 
                   String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    /**
     * Obtiene el SKU del producto.
     * 
     * @return SKU del producto.
     */
    public String getSku() { return sku; }
    /**
     * Obtiene el precio de venta al público del producto.
     * 
     * @return Precio de venta al público.
     */
    public double getPriceRetail() { return priceRetail; }
    /**
     * Obtiene el precio actual del producto.
     * 
     * @return Precio actual.
     */
    public double getPriceCurrent() { return priceCurrent; }
    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto.
     */
    public String getProductName() { return productName; }
    /**
     * Obtiene la categoría del producto.
     * 
     * @return Categoría del producto.
     */
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return String.format("SKU: %s, Nombre: %s, Precio de Venta: $%.2f, Precio Actual: $%.2f, Categoría: %s", 
                sku, productName, priceRetail, priceCurrent, category);
    }
}
