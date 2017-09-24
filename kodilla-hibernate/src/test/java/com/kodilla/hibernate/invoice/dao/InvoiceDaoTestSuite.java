package com.kodilla.hibernate.invoice.dao;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    private final Invoice invoice = new Invoice("FA/12345678");

    @Test
    public void testInvoiceDaoSave() {
        //Given
        prepareTestItemsForInvoice();
        //When
        invoiceDao.save(invoice);
        //Then
        final int id = invoice.getId();
        assertThat(invoiceDao.findOne(id))
                .extracting("number")
                .containsExactly("FA/12345678");
        //Clean up
        invoiceDao.delete(id);
    }

    private void prepareTestItemsForInvoice() {
        final Product book = new Product("Book");
        final Product computer = new Product("Computer");
        final Product mousePad = new Product("Mouse Pad");

        final Item itemBook = new Item(book, new BigDecimal(33), 3, invoice);
        final Item itemComputer = new Item(computer, new BigDecimal(4500), 1, invoice);
        final Item itemMousePad = new Item(mousePad, new BigDecimal(15), 1, invoice);

        invoice.getItems().add(itemBook);
        invoice.getItems().add(itemComputer);
        invoice.getItems().add(itemMousePad);
    }
}
