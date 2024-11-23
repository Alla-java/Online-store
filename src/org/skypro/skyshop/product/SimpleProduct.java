package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct); // Передача имени в конструктор родительского класса
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return this.priceProduct;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getPriceProduct();
    }
}
