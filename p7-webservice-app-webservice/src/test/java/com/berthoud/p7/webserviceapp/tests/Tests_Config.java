package com.berthoud.p7.webserviceapp.tests;

import com.berthoud.p7.webserviceapp.business.BookResearchManager;
import com.berthoud.p7.webserviceapp.business.CustomerManager;
import com.berthoud.p7.webserviceapp.business.LoanManager;
import com.berthoud.p7.webserviceapp.consumer.contract.LoanDAO;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.BookReferenceRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.BookRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.CustomerRepository;
import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.LoanRepository;
import com.berthoud.p7.webserviceapp.model.entities.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests_Config {

    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    LoanRepository loanRepo;

    @Autowired
    BookRepository bookRepo;

    @Autowired
    BookReferenceRepository bookReferenceRepository;

    @Autowired
    CustomerManager customerManager;

    @Autowired
    LoanManager loanManager;

    @Autowired
    BookResearchManager bookResearchManager;

    @Autowired
    LoanDAO loanDAO;

    @Test
    public void contextLoads() {
    }




















}
