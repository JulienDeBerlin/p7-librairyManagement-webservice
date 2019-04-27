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
    public void extendLoan(){
        loanManager.extendLoan(106);
    }



    @Test
    public void registerNewLoan(){

        // membership expired
        int testValue = loanManager.registerNewLoan(23, 5);
        assertEquals(testValue, 0);

        // book booked
        testValue = loanManager.registerNewLoan(34, 2);
        assertEquals(testValue, -3);

        // book borrowed
        testValue = loanManager.registerNewLoan(34, 7);
        assertEquals(testValue, -3);

        // book borrowed
        testValue = loanManager.registerNewLoan(34, 3);
        assertEquals(testValue, -3);

        // customer id wrong
        testValue = loanManager.registerNewLoan(22, 5);
        assertEquals(testValue, -2);

        //book id wrong
        testValue = loanManager.registerNewLoan(34, 19);
        assertEquals(testValue, -1);

        //ok
        testValue = loanManager.registerNewLoan(85, 1);
        assertEquals(testValue, 1);

    }


    @Test
    @Transactional
    public void bookBack(){

        //book id wrong
        int testValue = loanManager.bookBack(34);
        assertEquals(testValue, -1);

        //no loan is active
        testValue = loanManager.bookBack(2);
        assertEquals(testValue, 0);

        //return ok
        testValue = loanManager.bookBack(9);
        assertEquals(testValue, 1);

        //return ok
        testValue = loanManager.bookBack(4);
        assertEquals(testValue, 1);

    }



}
