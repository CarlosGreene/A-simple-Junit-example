package org.example.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    @Test
    void getTitle() {
        Product product = new Product("Test Product", 20);
        assertEquals("Test Product", product.getTitle());
    }

    @Test
    void getPrice() {
        Product product = new Product("Test Product", 20);
        assertEquals(20, product.getPrice(), 0.001); // Tolerancia para la comparación de números de punto flotante
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Product A", 10.0);
        Product product2 = new Product("Product B", 20.0);
        Product product3 = new Product("Product A", 30.0);

        assertTrue(product1.equals(product3)); // Deberían ser iguales por el título
        assertFalse(product1.equals(product2)); // No deberían ser iguales
    }
}