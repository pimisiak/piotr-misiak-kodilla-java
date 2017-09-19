package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;

final class Application {
    public static void main(final String[] args) {
        final User user = new User.UserBuilder("user123")
                .address("ul Rola 12/13")
                .firstName("Bartek")
                .lastName("Bartkowski")
                .email("bart@bart.com")
                .bankAccountNumber("9999-0000-9999-0000-9999")
                .build();
        final Product bookProduct = new Book.BookBuilder(123)
                .author("Bruce Eckel")
                .price(12.25)
                .title("Thinking in Java")
                .yearOfPublication(2007)
                .build();
        final Order orderForBook = new OrderImpl.Builder(123)
                .user(user)
                .dateOfOrder(LocalDateTime.of(2017, 8, 22, 12, 55, 15))
                .shippingAddress(user.getAddress())
                .addProduct(bookProduct, 1)
                .build();

        final ProductOrderService productOrderService = new ProductOrderService(new BankTransferService(), new MailService(), new ProductOrderRepository());
        productOrderService.processOrder(orderForBook);
    }
}
