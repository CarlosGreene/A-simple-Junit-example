package org.example.product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;


class ProductTest {

    static Product product;
    static Product product2;
    static Product product3;

    @BeforeAll
    static public void setUp() {
        product = new Product("Test Product", 20);
        product2 = new Product("Product A", 30.0);
        product3 = new Product("Test Product", 20.0);
    }

    @Test
    void getTitle() {
        assertNotNull(product.getTitle());

        assertEquals("Test Product", product.getTitle());
    }

    @Test
    void getPrice() {
        assertNotNull(product.getPrice());

        assertEquals(20, product.getPrice(), 0.001); // Tolerancia para la comparación de números de punto flotante
    }

    @Test
    void testEquals() {
        assertNotNull(product2.getTitle());
        assertNotNull(product3.getTitle());

        assertTrue(product.equals(product3)); // Deberían ser iguales por el título
        assertFalse(product.equals(product2)); // No deberían ser iguales
    }
}