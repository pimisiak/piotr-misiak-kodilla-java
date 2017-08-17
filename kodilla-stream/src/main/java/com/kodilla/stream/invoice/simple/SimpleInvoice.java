package com.kodilla.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

final class SimpleInvoice {
    private final List<SimpleItem> items = new ArrayList<>();

    void addItem(final SimpleItem item) {
        items.add(item);
    }

    boolean removeItem(final SimpleItem item) {
        return items.remove(item);
    }

    double getValueToPay() {
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
