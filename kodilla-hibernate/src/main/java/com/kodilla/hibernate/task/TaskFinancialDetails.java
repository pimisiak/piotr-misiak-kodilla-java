package com.kodilla.hibernate.task;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks_financials")
public class TaskFinancialDetails {
    private int id;
    private BigDecimal price;
    private boolean paid;

    public TaskFinancialDetails() {
    }

    public TaskFinancialDetails(final BigDecimal price, final boolean paid) {
        this.price = price;
        this.paid = paid;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "paid")
    public boolean isPaid() {
        return paid;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setPrice(final BigDecimal price) {
        this.price = price;
    }

    private void setPaid(final boolean paid) {
        this.paid = paid;
    }
}
