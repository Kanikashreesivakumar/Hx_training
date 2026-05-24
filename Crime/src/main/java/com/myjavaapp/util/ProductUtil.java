package com.myjavaapp.util;

import com.myjavaapp.enums.ProductSortField;
import com.myjavaapp.enums.SortDirection;
import com.myjavaapp.model.Product;
import com.myjavaapp.service.ProductService;

import java.util.List;

public class ProductUtil {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        List<Product> list =  productService.getSampleData();
        System.out.println("------Unsorted List---------");
        list.forEach(System.out::println);
        System.out.println("---------Sorted List (Default Sort: id)------------");
        List<Product> listProductsSortedWithDefault = productService.getProductsWithDefaultSort(list);
        listProductsSortedWithDefault.forEach(System.out::println);
        System.out.println("----------sorted list(sort price-asc------");
        List<Product> listCustomSorted = productService.customSort(list,ProductSortField.PRICE,SortDirection.ASC);
        listCustomSorted.forEach(System.out::println);
        System.out.println("-----sorted list(sorted price DESC---------");
        listCustomSorted = productService.customSort(list, ProductSortField.PRICE, SortDirection.DESC);
        listCustomSorted.forEach(System.out::println);
        System.out.println("--------Sorted List (Sort: Date of Publish-ASC------------ )");
        listCustomSorted = productService.customSort(list, ProductSortField.DATE_OF_PUBLISH, SortDirection.ASC);
        listCustomSorted.forEach(System.out::println);
        System.out.println("--------Sorted List (Sort: Date of Publish-DESC------------ )");
        listCustomSorted = productService.customSort(list, ProductSortField.DATE_OF_PUBLISH, SortDirection.DESC);
        listCustomSorted.forEach(System.out::println);
    }
}