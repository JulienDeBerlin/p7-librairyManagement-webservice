//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.11 à 10:17:43 PM CEST 
//


package com.berthoud.p7.webserviceapp.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.berthoud.p7.webserviceapp.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.berthoud.p7.webserviceapp.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCustomerByNicknameResponse }
     * 
     */
    public GetCustomerByNicknameResponse createGetCustomerByNicknameResponse() {
        return new GetCustomerByNicknameResponse();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link GetCustomerByIdRequest }
     * 
     */
    public GetCustomerByIdRequest createGetCustomerByIdRequest() {
        return new GetCustomerByIdRequest();
    }

    /**
     * Create an instance of {@link GetCustomerByIdResponse }
     * 
     */
    public GetCustomerByIdResponse createGetCustomerByIdResponse() {
        return new GetCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link GetCustomerByNicknameRequest }
     * 
     */
    public GetCustomerByNicknameRequest createGetCustomerByNicknameRequest() {
        return new GetCustomerByNicknameRequest();
    }

}
