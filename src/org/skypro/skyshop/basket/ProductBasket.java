package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
        initializeProducts();
    }

    // Метод инициализации продуктов
    private void initializeProducts() {
        addProduct(new SimpleProduct("Помидоры на ветке", 229));
        addProduct(new DiscountedProduct("Огурцы", 123, 10)); // Пример товара со скидкой
        addProduct(new SimpleProduct("Куриное филе", 329));
        addProduct(new FixPriceProduct("Фарш говяжий")); // Пример товара с фиксированной ценой
    }

    //Вспомогательный метод для добавления продукта в корзину
    private void addProduct(Product product) {
        String productName = product.getNameProduct();
        products.putIfAbsent(productName, new ArrayList<>());
        products.get(productName).add(product);
    }

    // Метод добавления продукта в корзину
    public void addProductInBasket(Product product) {
        addProduct(product);
    }

    // Метод для получения общей стоимости корзины
    public int getTotalCostBasket() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPriceProduct();
            }
        }
        return sum;
    }

    // Метод для отображения всех продуктов в корзине
    public void displayProductsInBasket() {
        int specialProductsCount = 0;
        int totalCost = 0;

        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product.toString());
                    totalCost += product.getPriceProduct();
                    if (product.isSpecial()) {
                        specialProductsCount++;
                    }
                }
            }
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + specialProductsCount);
        }
    }


    // Метод, проверяющий продукт в корзине по имени
    public boolean checkProductInBasket(String nameProduct) {
        List<Product> productList = products.get(nameProduct);
        return productList != null && !productList.isEmpty();
    }

    //Метод для очистки корзины
    public void clearBasket() {
        products.clear();
    }

    // Метод для удаления продукта по имени из корзины
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        List<Product> productList = products.get(name);

        if (productList != null) {
            removedProducts.addAll(productList);
            productList.clear();
        }

        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product.toString());
            }
        }

        return removedProducts;
    }
}
