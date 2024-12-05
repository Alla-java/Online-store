package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.common.SearchEngine;
import org.skypro.skyshop.common.Searchable;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
    }

}

