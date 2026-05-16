package com.myjavaapp.service;

import com.myjavaapp.enums.ProductSortField;
import com.myjavaapp.enums.SortDirection;
import com.myjavaapp.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getSampleData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 999.99, LocalDate.of(2025, 1, 10)));
        products.add(new Product(6, "Phone", 499.99, LocalDate.of(2026, 3, 15)));
        products.add(new Product(2, "Tablet", 299.99, LocalDate.of(2024, 8, 22)));
        products.add(new Product(8, "Smartwatch", 199.99, LocalDate.of(2025, 6, 1)));
        products.add(new Product(13, "Monitor", 349.99, LocalDate.of(2023, 11, 14)));
        products.add(new Product(7, "Headphones", 149.99, LocalDate.of(2026, 2, 28)));
        products.add(new Product(5, "Keyboard", 89.99, LocalDate.of(2024, 1, 5)));
        products.add(new Product(90, "Mouse", 49.99, LocalDate.of(2024, 1, 5))); // Same date as Keyboard
        products.add(new Product(88, "Gaming Console", 499.99, LocalDate.of(2025, 11, 20))); // Same price as Phone
        return products;
    }


    public List<Product> getProductsWithDefaultSort(List<Product> list) {
        return list
                .stream()
                .sorted()
                .toList();
    }

    public List<Product> customSort(List<Product> list,
                                    ProductSortField productSortField,
                                    SortDirection sortDirection) {
        if (productSortField.equals(ProductSortField.PRICE))
            if (sortDirection.equals(SortDirection.ASC))
                return list
                        .stream()
                        .sorted((p1, p2 )-> (int) (p1.getPrice() - p2.getPrice()))
                        .toList();
        if (sortDirection.equals(SortDirection.DESC))
            return list
                    .stream()
                    .sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
                    .toList();

        if (productSortField.equals(ProductSortField.DATE_OF_PUBLISH))
            if (sortDirection.equals(SortDirection.ASC))
                return list
                        .stream()
                        .sorted((p1, p2) -> p1.getDateOfPublish().compareTo(p2.getDateOfPublish()))
                        .toList();
        if (sortDirection.equals(SortDirection.DESC))
            return list
                    .stream()
                    .sorted((p1, p2) -> p2.getDateOfPublish().compareTo(p1.getDateOfPublish()))
                    .toList();

        return list;

    }
}
