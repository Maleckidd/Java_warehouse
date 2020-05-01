package com.warehouse.entity;

public class Product {
    private Long id;
    private String productName;
    private Float price;
    private Float weight;
    private String color;
    private int productCount;

    public Long getId() {
        return id;
    }

    public int getProductCount() {
        return productCount;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Product (Long id, String productName, Float price, Float weight, String color, int productCount){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
