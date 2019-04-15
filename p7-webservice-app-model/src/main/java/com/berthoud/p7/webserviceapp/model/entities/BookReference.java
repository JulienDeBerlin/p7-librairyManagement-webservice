package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BookReference extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String authorFirstName;
    private String authorSurname;
    private String isbn13;
    private String publisher;
    private String summary;
    private short yearPublication;


    public BookReference(int id, String title, String authorFirstName, String authorSurname, String isbn13, String publisher, String summary) {
        this.id = id;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorSurname = authorSurname;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.summary = summary;
        this.yearPublication = yearPublication;
    }

    public BookReference() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public short getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(short yearPublication) {
        this.yearPublication = yearPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookReference that = (BookReference) o;
        return id == that.id &&
                yearPublication == that.yearPublication &&
                title.equals(that.title) &&
                authorFirstName.equals(that.authorFirstName) &&
                authorSurname.equals(that.authorSurname) &&
                isbn13.equals(that.isbn13) &&
                publisher.equals(that.publisher) &&
                summary.equals(that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorFirstName, authorSurname, isbn13, publisher, summary, yearPublication);
    }
}
