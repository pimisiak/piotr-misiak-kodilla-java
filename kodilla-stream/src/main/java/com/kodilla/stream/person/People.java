package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public final class People {
    public static List<String> getList() {
        final List<String> list = new ArrayList<>();
        list.add("John Smith");
        list.add("Dorothy Newman");
        list.add("John Wolkowitz");
        list.add("Lucy Riley");
        list.add("Owen Rogers");
        list.add("Matilda Davies");
        list.add("Declan Booth");
        list.add("Corinne Foster");
        list.add("Khloe fry");
        list.add("Martin Valenzuela");
        return new ArrayList<String>(list);
    }
}
