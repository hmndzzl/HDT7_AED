package com.ejemplo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test {
    private BinarySearchTree<Product> bst;
    private Product product1, product2, product3;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
        product1 = new Product("SKU001", 100.0, 90.0, "Laptop", "Electronics");
        product2 = new Product("SKU002", 50.0, 45.0, "Mouse", "Accessories");
        product3 = new Product("SKU003", 200.0, 180.0, "Monitor", "Electronics");
    }

    @Test
    public void testInsert() {
        bst.insert(product1);
        bst.insert(product2);
        bst.insert(product3);

        assertEquals(3, bst.inorderTraversal().size());
    }

    @Test
    public void testSearch() {
        bst.insert(product1);
        bst.insert(product2);
        bst.insert(product3);

        Product found = bst.search(product2);
        assertNotNull(found);
        assertEquals("SKU002", found.getSku());
        assertEquals("Mouse", found.getProductName());
    }

    @Test
    public void testSearchNonExistentProduct() {
        bst.insert(product1);
        bst.insert(product2);

        Product nonExistent = new Product("SKU999", 0, 0, "", "");
        Product result = bst.search(nonExistent);
        assertNull(result);
    }
}