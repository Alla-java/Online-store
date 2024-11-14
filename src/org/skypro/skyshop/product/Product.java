package org.skypro.skyshop.product;

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

}
