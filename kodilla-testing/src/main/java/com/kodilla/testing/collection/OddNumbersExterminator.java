package com.kodilla.testing.collection;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public final class OddNumbersExterminator {
    private OddNumbersExterminator() {
    }

    public static ArrayList<Integer> exterminate(final List<Integer> list) {
        Preconditions.checkNotNull(list);
        final ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (Integer num : list) {
            if (num % 2 == 0) {
                evenList.add(num);
            }
        }
        return evenList;
    }
}
