package com.berthoud.p7.webserviceapp.tests;

import com.berthoud.p7.webserviceapp.business.LoanManager;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.BookRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.CustomerRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.LoanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

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
    @Transactional     /** ...without this annotation, rollback is like false... ! */
    public void extendLoan() {

        // extension ok
        int testValue = loanManager.extendLoan(36);
        assertEquals(testValue, 1);

        // membership expired
        testValue = loanManager.extendLoan(40);
        assertEquals(testValue, 0);

        // max amount extension reached
        testValue = loanManager.extendLoan(106);
        assertEquals(testValue, -1);

        // loan id not correct
        testValue = loanManager.extendLoan(1);
        assertEquals(testValue, -2);


    }


    @Test
    @Transactional
    public void registerNewLoan() {

        // book borrowed
        int testValue = loanManager.registerNewLoan(23, 4);
        assertEquals(testValue, -3);

        // book booked
        testValue = loanManager.registerNewLoan(34, 2);
        assertEquals(testValue, -3);

        //book id wrong
        testValue = loanManager.registerNewLoan(34, 19);
        assertEquals(testValue, -1);

        // ok
        testValue = loanManager.registerNewLoan(85, 7);
        assertEquals(testValue, 1);

        // membership expired
        testValue = loanManager.registerNewLoan(23, 8);
        assertEquals(testValue, 0);

    }


    @Test
    @Transactional
    public void bookBack() {

        //book id wrong
        int testValue = loanManager.bookBack(34);
        assertEquals(testValue, -1);

        //no loan is active
        testValue = loanManager.bookBack(2);
        assertEquals(testValue, 0);

        //return ok
        testValue = loanManager.bookBack(3);
        assertEquals(testValue, 1);

    }


}
