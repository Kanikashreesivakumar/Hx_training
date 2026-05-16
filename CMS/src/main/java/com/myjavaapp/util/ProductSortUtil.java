package com.myjavaapp.util;

import com.myjavaapp.model.Product;

import java.util.Comparator;

public class ProductSortUtil implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return (int) (p1.getPrice() - p2.getPrice());
    }

    /* @Override
    public int comparator(Product p1, Product p2) {
        return p1.getDateOfPublish().compareTo(p2.getDateOfPublish());
    }*/

}
