package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private String nameProduct;
    private int priceProduct;

    public Product(String nameProduct, int priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public int getPriceProduct() {
        return this.priceProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o; // Приведение к типу Product
        return priceProduct == product.priceProduct && Objects.equals(nameProduct, product.nameProduct);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, priceProduct);
    }

    }

