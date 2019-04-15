package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class UdcReference extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String reference;
    private String name;

    public UdcReference(int id, String reference, String name) {
        this.id = id;
        this.reference = reference;
        this.name = name;
    }

    public UdcReference() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UdcReference that = (UdcReference) o;
        return id == that.id &&
                reference.equals(that.reference) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, name);
    }
}
