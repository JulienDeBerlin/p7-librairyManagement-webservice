package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDate datePurchase;

    enum Status {
        AVAILABLE, BOOKED, BORROWED
    }
    private Status status;

    public Book(int id, LocalDate datePurchase, Status status) {
        this.id = id;
        this.datePurchase = datePurchase;
        this.status = status;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                datePurchase.equals(book.datePurchase) &&
                status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePurchase, status);
    }
}
