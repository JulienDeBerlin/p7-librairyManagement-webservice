
package com.berthoud.p7.webserviceapp.model.entities;


        import javax.persistence.*;
        import java.time.LocalDate;
        import java.util.Objects;


@Entity
public class CustomerEntity extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String surname;

    private String sex;

    private LocalDate dateExpirationMembership;
    private String phone;
    private String email;

    @Column(unique=true, nullable=false)
    private String nickname;
    private String password;


    public CustomerEntity(String firstName, String surname, String sex, LocalDate dateExpirationMembership, String phone, String email, String nickname, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.sex = sex;
        this.dateExpirationMembership = dateExpirationMembership;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }



    public CustomerEntity() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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
        CustomerEntity customerEntity = (CustomerEntity) o;
        return id == customerEntity.id &&
                firstName.equals(customerEntity.firstName) &&
                surname.equals(customerEntity.surname) &&
                sex == customerEntity.sex &&
                dateExpirationMembership.equals(customerEntity.dateExpirationMembership) &&
                phone.equals(customerEntity.phone) &&
                email.equals(customerEntity.email) &&
                nickname.equals(customerEntity.nickname) &&
                password.equals(customerEntity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, sex, dateExpirationMembership, phone, email, nickname, password);
    }
}
