package org.example.shoppingCart;

import org.example.product.Product;
import org.example.product.ProductNotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    static private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, cart.getBalance(), 0.001);
    }

    @Test
    @Disabled("for demonstration purposes")
    public void testAddItem() {
        Product product = new Product("Test Product", 19.99);
        cart.addItem(product);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() throws ProductNotFoundException {
        Product product = new Product("Test Product", 19.99);
        cart.addItem(product);
        cart.removeItem(product);
        assertEquals(0.0, cart.getBalance(), 0.001);
    }

    @Test
    public void testRemoveItemThrowsException() {
        assertThrows(ProductNotFoundException.class, () -> {
            Product product = new Product("Test Product", 19.99);
            cart.removeItem(product);
        });
    }

    @Test
    @Disabled("for demonstration purposes")
    public void testItemCount() {
        Product product1 = new Product("Product A", 10.0);
        Product product2 = new Product("Product B", 20.0);
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
    }

    @AfterEach
    public void testIsCartEmpty() {
        assertTrue(cart.isEmpty());
        Product product = new Product("Test Product", 19.99);
        cart.addItem(product);
        assertFalse(cart.isEmpty());
    }

    @AfterAll
    static public void testEmptyCart() {
        Product product = new Product("Test Product", 19.99);
        cart.addItem(product);
        cart.empty();
        assertAll("emptyCart",
            () -> assertEquals(0, cart.getItemCount()),
            () -> assertEquals(0.0, cart.getBalance(), 0.001),
            () -> assertTrue(cart.isEmpty())
        );

        //assertEquals(0, cart.getItemCount());
        //assertEquals(0.0, cart.getBalance(), 0.001);
        //assertTrue(cart.isEmpty();
    }
}