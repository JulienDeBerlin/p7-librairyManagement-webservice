package com.berthoud.p7.webserviceapp.consumer.contract;

import com.berthoud.p7.webserviceapp.model.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> findByNicknameAndPassword(String nickname, String password);
    Optional<Customer> findById(int id);


}
