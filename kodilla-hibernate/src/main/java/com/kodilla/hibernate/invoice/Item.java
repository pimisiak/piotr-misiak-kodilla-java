package com.kodilla.hibernate.invoice;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "items")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    protected Item() {
    }

    /**
     * Creates Item object.
     *
     * @param product Product object
     * @param price Price of product
     * @param quantity Quantity of product
     */
    public Item(final Product product, final BigDecimal price, final int quantity, final Invoice invoice) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(new BigDecimal(quantity));
        this.invoice = invoice;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    @NotNull
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    @NotNull
    @Column(name = "value")
    public BigDecimal getValue() {
        return value;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    public Invoice getInvoice() {
        return invoice;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setProduct(final Product product) {
        this.product = product;
    }

    private void setPrice(final BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    private void setValue(final BigDecimal value) {
        this.value = value;
    }

    public void setInvoice(final Invoice invoice) {
        this.invoice = invoice;
    }
}
