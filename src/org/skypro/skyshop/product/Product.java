package org.skypro.skyshop.product;

import org.skypro.skyshop.common.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String nameProduct;


    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("nameProduct не может быть null, пустым или состоять только из пробелов");
        }
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public abstract int getPriceProduct();

    // Абстрактный метод, который определяет, является ли товар специальным
    public boolean isSpecial() {
        return false; // По умолчанию товар не специальный
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct);
    }

    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @Override
    public String getName() {
        return getNameProduct();
    }

    @Override
    public String getStringRepresentation() {
        return getNameProduct() + " — PRODUCT";
    }

    @Override
    public abstract String toString();

}

