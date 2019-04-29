package com.berthoud.p7.webserviceapp.endpoints;

import com.berthoud.p7.webserviceapp.business.CustomerManager;
import com.berthoud.p7.webserviceapp.business.LoanManager;
import com.berthoud.p7.webserviceapp.model.entities.Book;
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
import java.util.ArrayList;
import java.util.List;

import static com.berthoud.p7.webserviceapp.utils.Utils.convertLocalDateForXml;


@Endpoint
@Transactional
public class CustomerAndLoanEndpoint {
    public static final String NAMESPACE_URI = "http://com.berthoud.p7";

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    LoanManager loanManager;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginCustomerRequest")
    @ResponsePayload
    public LoginCustomerResponse loginCustomer(@RequestPayload LoginCustomerRequest request) throws DatatypeConfigurationException {
        LoginCustomerResponse response = new LoginCustomerResponse();

        Customer customer = customerManager.login(request.getEmail(), request.getPassword());
        CustomerWs customerWs = new CustomerWs();

        BeanUtils.copyProperties(customer, customerWs);
        customerWs.setDateExpirationMembership(convertLocalDateForXml(customer.getDateExpirationMembership()));

        List<Loan> loanList = new ArrayList<>(customer.getLoans());
        customerWs.getLoans().addAll(loanMapping(loanList));

        response.setCustomer(customerWs);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "extendLoanRequest")
    @ResponsePayload
    public ExtendLoanResponse extendLoan(@RequestPayload ExtendLoanRequest request) {

        ExtendLoanResponse response = new ExtendLoanResponse();
        int resultCode = loanManager.extendLoan(request.getLoanId());
        response.setResultCode(resultCode);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerLoanRequest")
    @ResponsePayload
    public RegisterLoanResponse registerLoan(@RequestPayload RegisterLoanRequest request) {

        RegisterLoanResponse response = new RegisterLoanResponse();
        int resultCode = loanManager.registerNewLoan(request.getCustomerId(), request.getBookId());
        response.setResultCode(resultCode);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerBookReturnRequest")
    @ResponsePayload
    public RegisterBookReturnResponse registerBookBack(@RequestPayload RegisterBookReturnRequest request) {

        RegisterBookReturnResponse response = new RegisterBookReturnResponse();
        int resultCode = loanManager.bookBack(request.getBookId());
        response.setResultCode(resultCode);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOpenLoansRequest")
    @ResponsePayload
    public GetAllOpenLoansResponse getAllOpenLoans(@RequestPayload GetAllOpenLoansRequest request) throws DatatypeConfigurationException {

        GetAllOpenLoansResponse response = new GetAllOpenLoansResponse();
        List<Loan> loanList = loanManager.getAllOpenLoans();

        response.getLoans().addAll(loanMapping(loanList));

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOpenLoansInTimeRequest")
    @ResponsePayload
    public GetOpenLoansInTimeResponse getOpenLoansInTime(@RequestPayload GetOpenLoansInTimeRequest request) throws DatatypeConfigurationException {

        GetOpenLoansInTimeResponse response = new GetOpenLoansInTimeResponse();
        List<Loan> loanList = loanManager.getOpenLoansInTime();

        response.getLoans().addAll(loanMapping(loanList));

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOpenLoansLateRequest")
    @ResponsePayload
    public GetOpenLoansLateResponse getOpenLoansLate(@RequestPayload GetOpenLoansLateRequest request) throws DatatypeConfigurationException {

        GetOpenLoansLateResponse response = new GetOpenLoansLateResponse();
        List<Loan> loanList = loanManager.getOpenLoansLate();

        response.getLoans().addAll(loanMapping(loanList));

        return response;
    }


    private List<LoanWs> loanMapping(List<Loan> loanList) throws DatatypeConfigurationException {

        List<LoanWs> loanWsList = new ArrayList<>();

        for (Loan l : loanList) {
            LoanWs loanWs = new LoanWs();

            BeanUtils.copyProperties(l, loanWs);
            loanWs.setDateBegin(convertLocalDateForXml(l.getDateBegin()));
            loanWs.setDateEnd(convertLocalDateForXml(l.getDateEnd()));
            loanWs.setDateBack(convertLocalDateForXml(l.getDateBack()));

            Book book = l.getBook();
            BookWs bookWs = new BookWs();
            BeanUtils.copyProperties(book, bookWs);

            BookReferenceWs bookReferenceWs = new BookReferenceWs();
            BeanUtils.copyProperties(book.getBookReference(), bookReferenceWs);
            bookWs.setBookReference(bookReferenceWs);

            bookWs.setDatePurchase(convertLocalDateForXml(book.getDatePurchase()));

            LibrairyWs librairyWs = new LibrairyWs();
            BeanUtils.copyProperties(book.getLibrairy(), librairyWs);
            bookWs.setLibrairy(librairyWs);

            Book.Status status = book.getStatus();
            switch (status) {
                case AVAILABLE:
                    bookWs.setStatus(StatusWs.AVAILABLE);
                    break;
                case BOOKED:
                    bookWs.setStatus(StatusWs.BOOKED);
                    break;
                case BORROWED:
                    bookWs.setStatus(StatusWs.BORROWED);
                    break;
            }

            loanWs.setBook(bookWs);

            CustomerWs customerWs = new CustomerWs();
            BeanUtils.copyProperties(l.getCustomer(), customerWs);
            customerWs.setDateExpirationMembership(convertLocalDateForXml(l.getCustomer().getDateExpirationMembership()));

            loanWs.setCustomerWs(customerWs);

            loanWsList.add(loanWs);
        }


        return loanWsList;
    }

}






