package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1First = o1.split("/")[0];
        String o2First = o2.split("/")[0];
        return o1First.equals(o2First) ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}
