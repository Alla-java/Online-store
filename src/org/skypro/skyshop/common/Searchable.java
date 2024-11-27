package org.skypro.skyshop.common;

public interface Searchable {
    //Метод для получения термина поиска (search term)
    String getSearchTerm();

    //Метод для получения имени объекта
    String getName();

    //Метод для получения типа контента
    default String getStringRepresentation() {
        return getName() + " — " + getClass().getSimpleName();
    }
}
