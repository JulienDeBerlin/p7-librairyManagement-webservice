package com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA;

import com.berthoud.p7.webserviceapp.consumer.contract.BookReferenceDAO;
import com.berthoud.p7.webserviceapp.consumer.contract.CustomerDAO;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import org.springframework.data.repository.CrudRepository;

public interface BookReferenceRepository extends CrudRepository<BookReference, Integer>, BookReferenceDAO {
}
