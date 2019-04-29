package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.CustomerDAO;
import com.berthoud.p7.webserviceapp.model.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * This class is dedicated to the management of librairy user, called here customers.
 */

@Service
public class CustomerManager {

    @Autowired
    CustomerDAO customerDAO;

    /**
     * This method is used for the login of a customer.
     *
     * @param email    the email of the customer
     * @param password the password of the customer
     * @return If the password matches with the email, the corresponding Customer object is returned. Otherwise, null is returned.
     */
    public Customer login(String email, String password) {
        List<Customer> customerList = customerDAO.findByEmailAndPassword(email, password);
        if (customerList.isEmpty()) {
            return null;
        } else {
            return customerList.get(0);
        }
    }


}
