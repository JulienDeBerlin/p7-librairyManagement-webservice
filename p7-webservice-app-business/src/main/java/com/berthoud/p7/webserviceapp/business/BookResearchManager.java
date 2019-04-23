package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.BookReferenceDAO;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookResearchManager {

    @Autowired
    BookReferenceDAO bookReferenceDAO;

    public List<BookReference> findBookReferenceByTitle (String titleElement) {
       return bookReferenceDAO.findByTitleContainsIgnoreCase(titleElement);
    }
}
