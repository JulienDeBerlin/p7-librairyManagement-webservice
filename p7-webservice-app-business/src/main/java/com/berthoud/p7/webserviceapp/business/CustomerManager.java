package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.CustomerDAO;
import com.berthoud.p7.webserviceapp.model.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager {

    @Autowired
    CustomerDAO customerDAO;


    public Customer login (String nickname, String password){
        List<Customer> customerList = customerDAO.findByNicknameAndPassword(nickname, password);
        if (customerList.isEmpty()){
            return null;
        } else {
            return customerList.get(0);
        }
    }

    public Customer findById(int id){
       return customerDAO.findById(id).get();
    }

}
