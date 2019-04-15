package com.berthoud.p7.webserviceapp.consumer.contract;

import com.berthoud.p7.webserviceapp.model.entities.CustomerEntity;

public interface CustomerDAO {

    CustomerEntity findByNickname(String nickname);
    CustomerEntity findById(int id);


}
