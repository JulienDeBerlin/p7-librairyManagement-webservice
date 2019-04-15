package com.berthoud.p7.webserviceapp.business;
import com.berthoud.p7.webserviceapp.consumer.contract.LibrairyDAO;
import com.berthoud.p7.webserviceapp.model.entities.Librairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrairyManager {

    @Autowired
    LibrairyDAO librairyDAO;


    public Librairy findById(int id) {
      return librairyDAO.findById(id);
    }

}
