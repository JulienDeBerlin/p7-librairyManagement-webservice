package com.berthoud.p7.webserviceapp.endpoints;

import com.berthoud.p7.webserviceapp.business.CustomerManager;
import com.berthoud.p7.webserviceapp.model.entities.Customer;
import com.berthoud.p7.webserviceapp.model.entities.Loan;
import com.berthoud.p7.webserviceapp.ws.customers.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import static com.berthoud.p7.webserviceapp.utils.Utils.convertLocalDateForXml;


//@Endpoint registers the class with Spring WS as a potential candidate for processing incoming SOAP messages.
@Endpoint
@Transactional
public class CustomerEndpoint {
    public static final String NAMESPACE_URI = "http://com.berthoud.p7";

    @Autowired
    private CustomerManager customerManager;

    //@PayloadRoot is then used by Spring WS to pick the handler method based on the message’s namespace and localPart.

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginCustomerRequest")
    //The @ResponsePayload annotation makes Spring WS map the returned value to the response payload.
    @ResponsePayload
    //@RequestPayload indicates that the incoming message will be mapped to the method’s request parameter.
    public LoginCustomerResponse getResponse(@RequestPayload LoginCustomerRequest request) throws DatatypeConfigurationException {
        LoginCustomerResponse response = new LoginCustomerResponse();

        Customer customer = customerManager.login(request.getEmail(), request.getPassword());
        CustomerWs customerWs = new CustomerWs();

        BeanUtils.copyProperties(customer, customerWs);
        customerWs.setDateExpirationMembership(convertLocalDateForXml(customer.getDateExpirationMembership()));

        for (Loan l:customer.getLoans()) {
            LoanWs loansWs = new LoanWs();
            BeanUtils.copyProperties(l, loansWs);
            loansWs.setDateBegin(convertLocalDateForXml(l.getDateBegin()));
            loansWs.setDateEnd(convertLocalDateForXml(l.getDateEnd()));

            BookReferenceWs bookReferenceWs = new BookReferenceWs();
            BeanUtils.copyProperties(l.getBook().getBookReference(), bookReferenceWs);

            BookWs bookWs = new BookWs();
            BeanUtils.copyProperties(l.getBook(), bookWs);
            bookWs.setBookReference(bookReferenceWs);

            loansWs.setBook(bookWs);

            customerWs.getLoans().add(loansWs);
        }


        response.setCustomer(customerWs);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByIdRequest")
    @ResponsePayload
    public GetCustomerByIdResponse getCustomerById(@RequestPayload GetCustomerByIdRequest request) {
        GetCustomerByIdResponse response = new GetCustomerByIdResponse();

        Customer customer = customerManager.findById(request.getId());
        CustomerWs customerWs = new CustomerWs();

        BeanUtils.copyProperties(customer, customerWs);

        response.setCustomerType(customerWs);
        return response;
    }

}






