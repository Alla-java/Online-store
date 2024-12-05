package org.skypro.skyshop.common;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchTerm) {
        super("Не удалось найти подходящий объект для поискового запроса: " + searchTerm + " ");
    }
}
