package com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA;

import com.berthoud.p7.webserviceapp.consumer.contract.BookReferenceDAO;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookReferenceRepository extends CrudRepository<BookReference, Integer>, BookReferenceDAO {

    List<BookReference> findByTitleContainsIgnoreCase(String titleElement);

}
