package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Loan extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    private boolean isExtended;
    private LocalDate dateBack;

    public Loan(int id, LocalDate dateBegin, LocalDate dateEnd, boolean isExtended, LocalDate dateBack) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.isExtended = isExtended;
        this.dateBack = dateBack;
    }

    public Loan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isExtended() {
        return isExtended;
    }

    public void setExtended(boolean extended) {
        isExtended = extended;
    }

    public LocalDate getDateBack() {
        return dateBack;
    }

    public void setDateBack(LocalDate dateBack) {
        this.dateBack = dateBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return id == loan.id &&
                isExtended == loan.isExtended &&
                dateBegin.equals(loan.dateBegin) &&
                dateEnd.equals(loan.dateEnd) &&
                Objects.equals(dateBack, loan.dateBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateBegin, dateEnd, isExtended, dateBack);
    }
}
