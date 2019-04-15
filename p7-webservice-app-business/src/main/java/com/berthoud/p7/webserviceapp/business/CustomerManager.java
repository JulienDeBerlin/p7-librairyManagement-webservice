package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.CustomerDAO;
import com.berthoud.p7.webserviceapp.model.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {

    @Autowired
    CustomerDAO customerDAO;

    public CustomerEntity findByNickname(String nickname){
        return customerDAO.findByNickname(nickname);
    }

    public CustomerEntity findById(int id){
        return customerDAO.findById(id);
    }


}
