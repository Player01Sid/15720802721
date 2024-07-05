package com.example.top_products;

public class Product {
    private String productName;
    private int price;
    private String rating;
    private int discount;
    private String availability;

    public Product(String productName, int price, String rating, int discount, String availability) {
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.availability = availability;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                ", discount=" + discount +
                ", availability='" + availability + '\'' +
                '}';
    }
}
