package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        //Добавление продукта в корзину
        Product product1 = new Product("Хлеб бородинский", 49);
        System.out.println("1. Добавление продукта в корзину");
        basket.addProductInBasket(product1);


        //Добавление продукта в заполненную корзину, в которой нет свободного места
        Product product2 = new Product("Фарш куриный", 249);
        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        basket.addProductInBasket(product2);


        //Печать содержимого корзины с несколькими товарами
        System.out.println("3. Печать содержимого корзины с несколькими товарами");
        basket.displayProductsInBasket();


        // Выводим общую стоимость корзины
        System.out.println("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость корзины: " + basket.getTotalCostBasket());


        //Поиск товара, который есть в корзине
        System.out.println("5. Поиск товара, который есть в корзине:");
        boolean result = basket.checkProductInBasket("Огурцы");
        System.out.println(result);


        //Поиск товара, которого нет в корзине
        System.out.println("6. Поиск товара, которого нет в корзине:");
        boolean result2 = basket.checkProductInBasket("Холодец");
        System.out.println(result2);


        //Очистка корзины
        System.out.println("7. Очистка корзины");
        basket.clearBasket();

        //Печать содержимого пустой корзины
        System.out.println("8. Печать содержимого пустой корзины");
        basket.displayProductsInBasket();

        //Получение стоимости пустой корзины
        System.out.println("9. Получение стоимости пустой корзины");
        basket.getTotalCostBasket();

        //Поиск товара по имени в пустой корзине
        System.out.println("10. Поиск товара по имени в пустой корзине");
        boolean result3 = basket.checkProductInBasket("Холодец");
        System.out.println(result3);
    }

}

