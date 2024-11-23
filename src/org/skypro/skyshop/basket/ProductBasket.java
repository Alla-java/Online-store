package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        products = new Product[5];
        initializeProducts();
    }

    // Метод инициализации продуктов
    private void initializeProducts() {
        products[0] = new SimpleProduct("Помидоры на ветке", 229);
        products[1] = new DiscountedProduct("Огурцы", 123, 10); // Пример товара со скидкой
        products[2] = new SimpleProduct("Куриное филе", 329);
        products[3] = new FixPriceProduct("Фарш говяжий"); // Пример товара с фиксированной ценой
    }

    // Метод добавления продукта в корзину
    public void addProductInBasket(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
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
        int specialProductsCount = 0;
        int totalCost = 0;
        boolean isEmpty = true;

        for (Product product : products) {
            if (product != null) {
                isEmpty = false;
                System.out.println(product.toString());
                totalCost += product.getPriceProduct();
                if (product.isSpecial()) {
                    specialProductsCount++;
                }
            }
        }

        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + specialProductsCount);
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
