//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.11 à 10:17:43 PM CEST 
//


package com.berthoud.p7.webserviceapp.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sex" type="{http://com.berthoud.p7}sex"/>
 *         &lt;element name="dateExpirationMembership" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerType", propOrder = {
    "id",
    "firstName",
    "sex",
    "dateExpirationMembership",
    "phone",
    "email",
    "nickname"
})
public class CustomerType {

    protected int id;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected Sex sex;
    @XmlElement(required = true)
    protected String dateExpirationMembership;
    @XmlElement(required = true)
    protected String phone;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String nickname;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété firstName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Définit la valeur de la propriété firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Obtient la valeur de la propriété sex.
     * 
     * @return
     *     possible object is
     *     {@link Sex }
     *     
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Définit la valeur de la propriété sex.
     * 
     * @param value
     *     allowed object is
     *     {@link Sex }
     *     
     */
    public void setSex(Sex value) {
        this.sex = value;
    }

    /**
     * Obtient la valeur de la propriété dateExpirationMembership.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpirationMembership() {
        return dateExpirationMembership;
    }

    /**
     * Définit la valeur de la propriété dateExpirationMembership.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpirationMembership(String value) {
        this.dateExpirationMembership = value;
    }

    /**
     * Obtient la valeur de la propriété phone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Définit la valeur de la propriété phone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Obtient la valeur de la propriété email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtient la valeur de la propriété nickname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Définit la valeur de la propriété nickname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

}
