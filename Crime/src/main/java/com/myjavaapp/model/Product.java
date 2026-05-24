package com.myjavaapp.model;

import java.time.LocalDate;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private LocalDate dateOfPublish;

    public Product() {
    }

    public Product(int id, String name, double price, LocalDate dateOfPublish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateOfPublish = dateOfPublish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(LocalDate dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfPublish=" + dateOfPublish +
                '}';
    }

    @Override
    public int compareTo(Product p2) {
        return this.id - p2.id;
    }



}


