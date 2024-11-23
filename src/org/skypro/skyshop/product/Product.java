package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String nameProduct;


    public Product(String nameProduct) {
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

    // Переопределим метод toString в наследниках для правильного вывода
    @Override
    public abstract String toString();

    }

