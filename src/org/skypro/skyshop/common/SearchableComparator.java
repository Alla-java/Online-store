package org.skypro.skyshop.common;
import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {

        int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length()); // Сравниваем длины имен

        if (lengthComparison != 0) {
            return lengthComparison;
        } else {
            return o1.getName().compareTo(o2.getName()); // Если длины равны, сравниваем имена
        }
    }
}
