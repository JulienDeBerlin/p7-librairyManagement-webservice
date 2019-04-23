package com.berthoud.p7.webserviceapp.consumer.contract;

import com.berthoud.p7.webserviceapp.model.entities.BookReference;

import java.util.List;

public interface BookReferenceDAO {

    List<BookReference> findByTitleContainsIgnoreCase(String titleElement);

}
