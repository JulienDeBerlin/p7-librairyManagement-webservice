package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Librairy extends AuditModel{

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    public Librairy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Librairy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Librairy librairy = (Librairy) o;
        return id == librairy.id &&
                name.equals(librairy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
