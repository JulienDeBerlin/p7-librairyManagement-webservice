package com.berthoud.p7.webserviceapp.tests;

import com.berthoud.p7.webserviceapp.business.LoanManager;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.BookRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.CustomerRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.LoanRepository;
import com.berthoud.p7.webserviceapp.model.entities.Book;
import com.berthoud.p7.webserviceapp.model.entities.Customer;
import com.berthoud.p7.webserviceapp.model.entities.Loan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests_LoanManagement {

    @Autowired
    LoanManager loanManager;

    @Autowired
    LoanRepository loanRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    BookRepository bookRepo;


    @Test
    public void extendLoan(){
        loanManager.extendLoan(106);
    }

    @Test
    public void createLoan() {

        Customer c = customerRepo.findById(34).get();
        Book b = bookRepo.findById(1).get();

        Loan loan = new Loan();
        loan.setCustomer(c);
        loan.setBook(b);

        loan.setDateBegin(LocalDate.of(2019, 04, 13));
        loan.setDateEnd(LocalDate.of(2019, 04, 23));
        loan.setNumberExtensions(0);

        loanRepo.save(loan);
    }

}
