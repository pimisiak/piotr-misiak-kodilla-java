package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public final class OddNumbersExterminator {
    private OddNumbersExterminator() {
    }

    public static ArrayList<Integer> exterminate(final List<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }
        final List<Integer> evenList = new ArrayList<Integer>();
        for (Integer num : list) {
            if (num % 2 == 0) {
                evenList.add(num);
            }
        }
        return new ArrayList<Integer>(evenList);
    }
}
