package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        products = new Product[5];
        initializeProducts();
    }

    // Метод инициализации продуктов
    private void initializeProducts() {
        products[0] = new Product("Помидоры на ветке", 229);
        products[1] = new Product("Огурцы", 123);
        products[2] = new Product("Куриное филе", 329);
        products[3] = new Product("Фарш говяжий", 429);

    }

    // Метод добавления продукта в корзину
    public void addProductInBasket(Product product) {
        for (int i = 0; i < products.length; i = i + 1) {
            if (products[i] == null) {
                products[i] = product;
                return;  // Продукт добавлен, выходим из метода
            }
        }
        System.out.println("Невозможно добавить продукт, корзина заполнена");
    }

    // Метод для получения общей стоимости корзины
    public int getTotalCostBasket() {
        int sum = 0;
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null) {
                sum += product.getPriceProduct();
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Итого: 0");
        }
        return sum;
    }

    // Метод для отображения всех продуктов в корзине
    public void displayProductsInBasket() {
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null) {
                isEmpty = false;
                System.out.println(product.getNameProduct() + ": " + product.getPriceProduct());
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        }
    }


    //Метод, проверяющий продукт в корзине по имени
    public boolean checkProductInBasket(String nameProduct) {
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null && product.getNameProduct().equalsIgnoreCase(nameProduct)) {
                return true;
            }
            if (product != null) {
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        }
        return false;
    }

    //Метод для очистки корзины
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }


}
