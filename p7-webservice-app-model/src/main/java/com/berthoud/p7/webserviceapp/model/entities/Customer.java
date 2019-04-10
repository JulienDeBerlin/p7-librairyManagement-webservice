
package com.berthoud.p7.webserviceapp.model.entities;


        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import java.time.LocalDate;
        import java.util.Objects;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String surname;

    enum Sex{
            MALE, FEMALE,OTHER
    }
    private Sex sex;

    private LocalDate dateExpirationMembership;
    private String phone;
    private String email;
    private String nickname;
    private String password;

    public Customer(String firstName, String surname, Sex sex, LocalDate dateExpirationMembership, String phone, String email, String nickname, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.sex = sex;
        this.dateExpirationMembership = dateExpirationMembership;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateExpirationMembership() {
        return dateExpirationMembership;
    }

    public void setDateExpirationMembership(LocalDate dateExpirationMembership) {
        this.dateExpirationMembership = dateExpirationMembership;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                firstName.equals(customer.firstName) &&
                surname.equals(customer.surname) &&
                sex == customer.sex &&
                dateExpirationMembership.equals(customer.dateExpirationMembership) &&
                phone.equals(customer.phone) &&
                email.equals(customer.email) &&
                nickname.equals(customer.nickname) &&
                password.equals(customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, sex, dateExpirationMembership, phone, email, nickname, password);
    }
}
