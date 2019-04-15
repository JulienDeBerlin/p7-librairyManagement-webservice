package com.berthoud.p7.webserviceapp.consumer.repositories.JPA;

import com.berthoud.p7.webserviceapp.consumer.contract.LibrairyDAO;
import com.berthoud.p7.webserviceapp.model.entities.Librairy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class LibrairyRepository implements LibrairyDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Librairy findById(int id){
        return entityManager.find(Librairy.class, id);
    }
}
