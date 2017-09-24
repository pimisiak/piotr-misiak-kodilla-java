package com.kodilla.hibernate.invoice;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoices")
public class Invoice {
    private int id;
    private String number;
    private List<Item> items = new ArrayList<>();

    protected Invoice() {
    }

    public Invoice(final String number) {
        this.number = number;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "number", unique = true)
    public String getNumber() {
        return number;
    }

    @OneToMany(
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setNumber(final String number) {
        this.number = number;
    }

    private void setItems(final List<Item> items) {
        this.items = items;
    }
}
