package org.skypro.skyshop.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable); // Добавляем объект в список
    }


    public Map<String, Searchable> search(String searchTerm) {
        Map<String, Searchable> resultMap = new TreeMap<>(); // Список для хранения результатов поиска

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(searchTerm)) {
                resultMap.put(searchable.getName(), searchable);
            }
        }
        return resultMap;
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
