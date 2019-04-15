package com.berthoud.p7.webserviceapp.consumer.contract;

import com.berthoud.p7.webserviceapp.model.entities.Librairy;


public interface LibrairyDAO {

    Librairy findById(int id);

}
