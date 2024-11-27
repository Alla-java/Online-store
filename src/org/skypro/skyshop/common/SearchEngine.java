package org.skypro.skyshop.common;

import org.skypro.skyshop.common.Searchable;

public class SearchEngine {
    private final Searchable[] searchables; // Массив элементов для поиска
    private int currentIndex = 0; // Текущий индекс для добавления новых объектов

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть положительным");
        }
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (currentIndex >= searchables.length) {
            System.out.println("Невозможно добавить объект: массив заполнен");
            return;
        }
        searchables[currentIndex++] = searchable;
    }


    public Searchable[] search(String searchTerm) {
        Searchable[] resultArray = new Searchable[5]; // Массив для хранения результатов поиска
        int count = 0; // Счётчик найденных элементов

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(searchTerm)) {
                resultArray[count++] = searchable; // Добавляем найденный элемент
                if (count == 5) {
                    break;
                }
            }
        }

        return resultArray;
    }

}
