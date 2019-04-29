package com.berthoud.p7.webserviceapp.endpoints;

import com.berthoud.p7.webserviceapp.business.BookResearchManager;
import com.berthoud.p7.webserviceapp.model.entities.Book;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import com.berthoud.p7.webserviceapp.utils.Utils;
import com.berthoud.p7.webserviceapp.ws.books.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;


@Endpoint
@Transactional
public class BookEndpoint {
    public static final String NAMESPACE_URI = "http://com.berthoud.p7";

    @Autowired
    private BookResearchManager bookResearchManager;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "bookRequest")
    @ResponsePayload
    public BookResponse getResponse(@RequestPayload BookRequest r) throws DatatypeConfigurationException {
        BookResponse response = new BookResponse();

        List<BookReference> bookReferenceList =
                bookResearchManager.findBookMultiParameters(r.getAuthorSurname(), r.getTitleElement(), r.getLibrairyId(), r.getTags());

        for (BookReference b:bookReferenceList) {

            BookReferenceWs bookReferenceWs = new BookReferenceWs();

            BeanUtils.copyProperties(b,bookReferenceWs);

            for (Book book: b.getBooks() ) {
                BookWs bookWs = new BookWs();
                BeanUtils.copyProperties(book,bookWs);

                LibrairyWs librairyWs = new LibrairyWs();
                BeanUtils.copyProperties(book.getLibrairy(),librairyWs);
                bookWs.setLibrairy(librairyWs);
                bookWs.setDatePurchase(Utils.convertLocalDateForXml(book.getDatePurchase()));


                Book.Status status = book.getStatus();
                switch (status) {
                    case AVAILABLE   : bookWs.setStatus(StatusWs.AVAILABLE); break;
                    case BOOKED      : bookWs.setStatus(StatusWs.BOOKED); break;
                    case BORROWED    : bookWs.setStatus(StatusWs.BORROWED); break;
                }

                bookReferenceWs.getBook().add(bookWs);
            }

            response.getBookReferences().add(bookReferenceWs);
        }

        return response;
    }



}