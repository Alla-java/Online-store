package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.common.BestResultNotFound;
import org.skypro.skyshop.common.SearchEngine;
import org.skypro.skyshop.common.Searchable;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.common.SearchEngine;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        //Добавление продукта в корзину
        SimpleProduct product1 = new SimpleProduct("Хлеб бородинский", 49);
        System.out.println("1. Добавление продукта в корзину");
        basket.addProductInBasket(product1);


        //Добавление продукта в заполненную корзину, в которой нет свободного места
        SimpleProduct product2 = new SimpleProduct("Фарш куриный", 249);
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



        //Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов
        SearchEngine engine = new SearchEngine(10);
        engine.add(product1);
        engine.add(product2);

        //Создайте несколько объектов типа Article и добавьте их в Search Engine
        Article article1 = new Article("Фасоль: польза и вред для организма", "Текст статьи про шакшуку");
        Article article2 = new Article("Рыбы Черного моря: гид от шеф-повара", "Текст статьи про рыб");
        Article article3 = new Article("Чем полезна жимолость и как ее готовить", "Текст статьи про жимолость");
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        // Пытаемся найти товары и статьи по запросу "Фасоль"
        Searchable[] results = engine.search("Фасоль");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Фасоль':");
        for (Searchable result4 : results) {
            if (result4 != null) {
                System.out.println(result4.getStringRepresentation());
            }
        }

        // Пытаемся найти товары и статьи по запросу "Рыбы"
        results = engine.search("Рыбы");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Рыбы':");
        for (Searchable result5 : results) {
            if (result5 != null) {
                System.out.println(result5.getStringRepresentation());
            }
        }

        // Пытаемся найти товары и статьи по запросу "Хлеб"
        results = engine.search("Хлеб");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Хлеб':");
        for (Searchable result6 : results) {
            if (result6 != null) {
                System.out.println(result6.getStringRepresentation());
            }
        }


        //Домашняя работа по теме: Исключения в Java

        SimpleProduct product3 = new SimpleProduct("                ", 49); // Ошибка: имя состоит из пробелов
        SimpleProduct product4 = new SimpleProduct("Пиво Жигулевское", 0); // Ошибка: цена 0
        DiscountedProduct product5 = new DiscountedProduct("Лапша Роллтон", -100, 10); // Ошибка: базовая цена отрицательная
        DiscountedProduct product6 = new DiscountedProduct("Овес", 500, 110); // Ошибка: скидка > 100%
        SimpleProduct product7 = new SimpleProduct(null, 49); // Ошибка: имя не заполнено

        try {
             System.out.println("SimpleProduct created: " + product3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating SimpleProduct: " + e.getMessage());
        }

        try {
            System.out.println("SimpleProduct created: " + product4);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании SimpleProduct: " + e.getMessage());
        }

        try {
            System.out.println("DiscountedProduct created: " + product5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании DiscountedProduct: " + e.getMessage());
        }

        try {
            System.out.println("DiscountedProduct created: " + product6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании DiscountedProduct: " + e.getMessage());
        }

        try {
            System.out.println("SimpleProduct created: " + product7);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании SimpleProduct: " + e.getMessage());
        }

        // Демонстрация работы метода findBestMatch

        // 1. Сценарий, когда нужный объект существует
        try {
            Searchable bestMatch = engine.findBestMatch("Хлеб");
            System.out.println("Наиболее подходящий объект: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // 2. Сценарий, когда метод выбрасывает исключение
        try {
            Searchable bestMatch = engine.findBestMatch("Шоколад");
            System.out.println("Наиболее подходящий объект: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}

