package org.example.product;

public class Product {

    private String _title;
    private double _price;

    public Product(String title, double price) {
        _title = title;
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    public double getPrice() {
        return _price;
    }

    public boolean equals(Object o) {

        if (o instanceof Product) {
            Product p = (Product)o;
            return p.getTitle().equals(_title);
        }

        return false;
    }
}
