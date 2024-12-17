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

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        //Добавление продукта в корзину
        SimpleProduct product1 = new SimpleProduct("Хлеб бородинский", 49);
        System.out.println("1. Добавление продукта в корзину");
        basket.addProductInBasket(product1);



        SimpleProduct product2 = new SimpleProduct("Фарш куриный", 249);



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


        //Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов
        SearchEngine engine = new SearchEngine();
        engine.add(product1);
        engine.add(product2);

        //Создайте несколько объектов типа Article и добавьте их в Search Engine
        Article article1 = new Article("фасоль: польза и вред для организма", "Текст статьи про шакшуку");
        Article article2 = new Article("Рыбы Черного моря: гид от шеф-повара", "Текст статьи про рыб");
        Article article3 = new Article("Чем полезна жимолость и как ее готовить", "Текст статьи про жимолость");
        Article article4 = new Article("Красная или белая фасоль: что полезнее", "Текст статьи про фасоль");
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);

        // Пытаемся найти товары и статьи по запросу "Фасоль"
        Map<String, Searchable> results = engine.search("фасоль");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Фасоль':");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
        }

        // Пытаемся найти товары и статьи по запросу "Рыбы"
        results = engine.search("Рыбы");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Рыбы':");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
        }

        // Пытаемся найти товары и статьи по запросу "Хлеб"
        results = engine.search("Хлеб");

        // Выводим результаты поиска
        System.out.println("Результаты поиска по запросу 'Хлеб':");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
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

        //Демонстрация работы метода удаления продукта по имени из корзины
        System.out.println("1. Удалить существующий продукт из корзины и 2.Вывести удаленные продукты на экран");
        basket.removeProductsByName("Огурцы");
        System.out.println("3. Вывести содержимое корзины с помощью метода printBacket");
        basket.displayProductsInBasket();
        System.out.println("4. Удалить несуществующий продукт и 5. Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”");
        basket.removeProductsByName("Икра заморская баклажанная");
        System.out.println("6. Вывести содержимое корзины на экран");
        basket.displayProductsInBasket();
    }
}

