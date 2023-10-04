package org.example.shoppingCart;

import org.example.product.Product;
import org.example.product.ProductNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList _items;

    public ShoppingCart() {
        _items = new ArrayList();
    }

    public double getBalance() {
        Iterator i = _items.iterator();
        double balance = 0.00;
        while (i.hasNext()) {
            Product p = (Product)i.next();
            balance = balance + p.getPrice();
        }

        return balance;
    }

    public void addItem(Product p) {
        _items.add(p);
    }

    public void removeItem(Product p) throws ProductNotFoundException {
        if (!_items.remove(p)) {
            throw new ProductNotFoundException();
        }
    }

    public int getItemCount() {
        return _items.size();
    }

    public void empty() {
        _items = new ArrayList();
    }

    public boolean isEmpty() {
        return (_items.size() == 0);
    }
}
