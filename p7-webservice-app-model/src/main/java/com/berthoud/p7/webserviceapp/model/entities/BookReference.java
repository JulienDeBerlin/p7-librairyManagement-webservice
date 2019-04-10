package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BookReference {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String authorFirstName;
    private String authorSurname;
    private String isbn13;
    private String publisher;
    private String summary;

    public BookReference(int id, String name, String authorFirstName, String authorSurname, String isbn13, String publisher, String summary) {
        this.id = id;
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorSurname = authorSurname;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.summary = summary;
    }

    public BookReference() {
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

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookReference that = (BookReference) o;
        return id == that.id &&
                name.equals(that.name) &&
                authorFirstName.equals(that.authorFirstName) &&
                authorSurname.equals(that.authorSurname) &&
                isbn13.equals(that.isbn13) &&
                publisher.equals(that.publisher) &&
                summary.equals(that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authorFirstName, authorSurname, isbn13, publisher, summary);
    }
}
