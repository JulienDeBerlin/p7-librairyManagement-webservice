package com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA;

import com.berthoud.p7.webserviceapp.model.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositorySpringDataJPA extends CrudRepository <CustomerEntity, Integer> {
}
