package org.skypro.skyshop.common;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new TreeSet<>(new SearchableComparator());
    }

    public void add(Searchable searchable) {
        searchables.add(searchable); // Добавляем объект в список
    }

    public Set<Searchable> search(String searchTerm) {
        return searchables.stream() // Преобразуем коллекцию searchables в поток stream API
                .filter(searchable -> searchable != null && searchable.getSearchTerm().contains(searchTerm)) // Фильтруем по условию
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator()))); // Лямбда-выражение для Supplier
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }


    @Override
    public int hashCode() {
        return Objects.hash(searchables);
    }







}
