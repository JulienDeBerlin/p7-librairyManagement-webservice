package com.berthoud.p7.webserviceapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String additionalAddressField1;
    private String additionalAddressField2;

    private String road;
    private int houseNumber;
    private String zipCode;
    private String city;


    public Address(int id, String additionalAddressField1, String additionalAddressField2, String road, int houseNumber, String zipCode, String city) {
        this.id = id;
        this.additionalAddressField1 = additionalAddressField1;
        this.additionalAddressField2 = additionalAddressField2;
        this.road = road;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdditionalAddressField1() {
        return additionalAddressField1;
    }

    public void setAdditionalAddressField1(String additionalAddressField1) {
        this.additionalAddressField1 = additionalAddressField1;
    }

    public String getAdditionalAddressField2() {
        return additionalAddressField2;
    }

    public void setAdditionalAddressField2(String additionalAddressField2) {
        this.additionalAddressField2 = additionalAddressField2;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                houseNumber == address.houseNumber &&
                Objects.equals(additionalAddressField1, address.additionalAddressField1) &&
                Objects.equals(additionalAddressField2, address.additionalAddressField2) &&
                road.equals(address.road) &&
                zipCode.equals(address.zipCode) &&
                city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, additionalAddressField1, additionalAddressField2, road, houseNumber, zipCode, city);
    }
}
