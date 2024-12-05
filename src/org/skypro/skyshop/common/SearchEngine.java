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

    //Метод поиска наиболее подходящего объекта
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковая строка не должна быть пустой или null");
        }

        Searchable bestMatch = null; // Наиболее подходящий объект
        int maxOccurrences = 0; // Максимальное количество повторений строки search

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int occurrences = countOccurrences(searchable.getSearchTerm(), search);
                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    // Вспомогательный метод для подсчёта количества повторений строки search в строке term
    private int countOccurrences(String term, String search) {
        int count = 0;
        int index = 0;

        while ((index = term.indexOf(search, index)) != -1) {
            count++;
            index += search.length(); // Сдвигаем индекс после найденного вхождения
        }

        return count;
    }





}
