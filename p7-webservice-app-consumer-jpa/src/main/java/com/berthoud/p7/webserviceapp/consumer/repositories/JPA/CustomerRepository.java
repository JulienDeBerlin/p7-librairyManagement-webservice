package com.berthoud.p7.webserviceapp.consumer.repositories.JPA;

import com.berthoud.p7.webserviceapp.consumer.contract.CustomerDAO;
import com.berthoud.p7.webserviceapp.model.entities.CustomerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


    @Repository
    @Transactional
    public class CustomerRepository implements CustomerDAO {

        @PersistenceContext
        EntityManager entityManager;


        @Override
        public CustomerEntity findById(int id) {
            CustomerEntity customerEntity=entityManager.find(CustomerEntity.class,id);
            System.out.println(customerEntity);
            return customerEntity;
        }


        public CustomerEntity findByNickname(String nickname){
            CustomerEntity customerEntity=entityManager.find(CustomerEntity.class,nickname);
            System.out.println(customerEntity);
            return customerEntity;

        }






    }



