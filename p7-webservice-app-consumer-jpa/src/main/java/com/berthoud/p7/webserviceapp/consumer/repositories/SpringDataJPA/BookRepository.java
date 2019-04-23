package com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA;

import com.berthoud.p7.webserviceapp.consumer.contract.BookDAO;
import com.berthoud.p7.webserviceapp.model.entities.Book;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer>, BookDAO {


}
