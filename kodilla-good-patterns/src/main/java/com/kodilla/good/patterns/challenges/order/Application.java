package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;

final class Application {
    public static void main(final String[] args) {
        User user = new User.UserBuilder("user123")
                .address("ul Rola 12/13")
                .firstName("Bartek")
                .lastName("Bartkowski")
                .email("bart@bart.com")
                .build();
        Order orderForBook = new Order.OrderBuilder(123)
                .user(user)
                .dateOfOrder(LocalDateTime.of(2017, 8, 22, 12, 55, 15))
                .shippingAddress(user.getAddress())
                .build();
        Product bookProduct = new Product("Book", 12.35);
        bookProduct.addProperty("Title", "Thinking in Java");
        bookProduct.addProperty("Author", "Bruce Eckel");
        orderForBook.addProduct(bookProduct, 1);

        ProductOrderService productOrderService = new ProductOrderService(new BankTransferService(), new MailService(), new ProductOrderRepository());
        OrderDto orderForBookDto = productOrderService.processOrder(orderForBook);
    }
}
