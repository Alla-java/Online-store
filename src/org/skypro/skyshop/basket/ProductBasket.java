package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
        initializeProducts();
    }

    // Метод инициализации продуктов
    private void initializeProducts() {
        products.add(new SimpleProduct("Помидоры на ветке", 229));
        products.add(new DiscountedProduct("Огурцы", 123, 10)); // Пример товара со скидкой
        products.add(new SimpleProduct("Куриное филе", 329));
        products.add(new FixPriceProduct("Фарш говяжий")); // Пример товара с фиксированной ценой
    }

    // Метод добавления продукта в корзину
    public void addProductInBasket(Product product) {
        products.add(product);
    }

    // Метод для получения общей стоимости корзины
    public int getTotalCostBasket() {
        int sum = 0;
        if (products.isEmpty()) {
            System.out.println("Итого: 0");
        } else {
            for (Product product : products) {
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
            for (Product product : products) {
                System.out.println(product.toString());
                totalCost += product.getPriceProduct();
                if (product.isSpecial()) {
                    specialProductsCount++;
                }
            }
            System.out.println("Итого: " + totalCost);
            System.out.println("Специальных товаров: " + specialProductsCount);
        }
    }


    //Метод, проверяющий продукт в корзине по имени
    public boolean checkProductInBasket(String nameProduct) {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return false;
        }

        for (Product product : products) {
            if (product != null && product.getNameProduct().equalsIgnoreCase(nameProduct)) {
                return true;
            }
        }
        return false;
    }

    //Метод для очистки корзины
    public void clearBasket() {
        products.clear();
    }

    //Метод для удаления продукта по имени из корзины
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getNameProduct().equalsIgnoreCase(name)) {
                iterator.remove(); // Удаляем продукт из списка
                removedProducts.add(product); // Добавляем его в список удалённых продуктов
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст"); // Если искомого продукта в корзине нет, выводим сообщение
        }
        else {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product.toString()); // Выводим каждый удалённый продукт
            }
        }
        return removedProducts; // Возвращаем список удалённых продуктов
    }




}
