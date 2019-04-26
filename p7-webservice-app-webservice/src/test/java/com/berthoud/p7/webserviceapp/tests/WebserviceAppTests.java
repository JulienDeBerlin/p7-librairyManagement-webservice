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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebserviceAppTests {

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


    @Test
    public void testRead() {
        if (customerRepo.findById(4).isPresent()) {
            Customer customer = customerRepo.findById(4).get();
            System.out.println(customer.getSurname());
        }

    }


    @Test
    public void testUpdate() {
        Optional<Customer> customer = customerRepo.findById(23);
        if (customer.isPresent()) {
            Customer myCustomer = customer.get();
            myCustomer.setSurname("Dubuquette");
            customerRepo.save(myCustomer);
        }
    }

    @Test
    public void testDelete() {
        if (customerRepo.existsById(3)) {
            customerRepo.deleteById(3);
        }

    }

    @Test
    public void testCount() {
        System.out.println("Total records: =============" + customerRepo.count());

    }

    @Test
    public void testFindBy() {
        List<Customer> listCustomer = customerRepo.findBySurnameIgnoreCase("PierRE");
        for (Customer c : listCustomer) {
            System.out.println(">>>>>>>>>>>>id = " + c.getId());
        }
    }


    @Test
    public void testFindAllJPQL() {
        customerRepo.findAllJPQL().forEach(customerEntity -> System.out.println(customerEntity.getFirstName()));
    }

    @Test
    public void testFindAllPartialData() {
        customerRepo.findAllPartialData().forEach(objects -> System.out.println(objects[0] + "/" + objects[1] + "/" + objects[2]));

    }


    @Test
//    @Transactional
    public void insertUsers() {

        Customer c1 = new Customer();
        c1.setSurname("Malika");
        c1.setFirstName("Djarir");
        c1.setPassword("soleil");
        c1.setSex("F");
        c1.setPhone("0385303955");
        c1.setEmail("aicha@yahoo.fr");

        Address address = new Address();
        address.setHouseNumber(13);
        address.setCity("Paris");
        address.setZipCode("75009");
        address.setRoad("rue de Milan");

        c1.setAddress(address);

        customerRepo.save(c1);
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


    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customer.setSurname("Pierre");
        customer.setFirstName("Dubuc");
        customer.setPassword("soleil");
        customer.setSex("M");
        customer.setPhone("0385303955");
        customer.setEmail("pierre@yahoo.fr");

        customerRepo.save(customer);

    }


    @Test
    @Transactional
    public void testLogin() {
        Customer customer1 = customerManager.login("malika@yahoo.fr", "soleil");
        assertNotNull(customer1);


//        Customer customer1 = customerRepo.findById(30).get();

        System.out.println(customer1.getFirstName() + " " + customer1.getSurname() + "  Id=" + customer1.getId());
        System.out.println(customer1.getAddress().getCity());

        Set<Loan> loans = customer1.getLoans();
        loans.forEach(loan -> System.out.println("Titre= " + loan.getBook().getBookReference().getTitle() + "Debut=" + loan.getDateBegin() + "Fin:" + loan.getDateEnd()));

    }


    @Test
    @Transactional
    public void findBookByTitle() {
        List<BookReference> bookReferenceList = bookResearchManager.findBookReferenceByTitle("itALie");
        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setStatus(Book.Status.AVAILABLE);
        book.setDatePurchase(LocalDate.of(2019, 03, 23));
        bookRepo.save(book);
    }


    @Test
    @Transactional
    public void findByTags() {

        List<BookReference> bookReferenceList =
                bookReferenceRepository.findBookReferenceByTags(new HashSet<>(Arrays.asList("Sport", "Aventure", "Ecologie")), 3);

        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }

        if (bookReferenceList.isEmpty()) {
            System.out.println("EMPTY!!!!");
        }

    }

    @Test
    @Transactional
    public void findByTagsAndAuthor() {

        List<BookReference> bookReferenceList =
                bookReferenceRepository.findBookReferenceByTagsAndAuthor(new HashSet<>(Arrays.asList("Sport", "Aventure", "Ecologie")), 3, "Surty");

        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }

        if (bookReferenceList.isEmpty()) {
            System.out.println("EMPTY!!!!");
        }

    }


    @Test
    @Transactional
    public void findByTagsAndTitleElement() {

        List<BookReference> bookReferenceList =
                bookReferenceRepository.findBookReferenceByTagsAndTitleElement(new HashSet<>(Arrays.asList("Sport", "Aventure", "Ecologie")), 3, "les septs");

        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }

        if (bookReferenceList.isEmpty()) {
            System.out.println("EMPTY!!!!");
        }

    }

    @Test
    @Transactional
    public void findByTagsAndTitleElementAndAuthor() {

        List<BookReference> bookReferenceList =
                bookReferenceRepository.findBookReferenceByTagsAndTitleElementAndAuthor
                        (new HashSet<>(Arrays.asList("Sport", "Aventure", "Ecologie")), 3, "%les septs %", "sur");

        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }

        if (bookReferenceList.isEmpty()) {
            System.out.println("EMPTY!!!!");
        }

    }


    @Test
    @Transactional
    public void finderTestJPQL() {

        List<BookReference> bookReferenceList =
                bookReferenceRepository.findBookReferenceTestJPQL("Sur");

        for (BookReference bookReference : bookReferenceList) {
            System.out.println(bookReference.getTitle());
            for (Book book : bookReference.getBooks()) {
                System.out.println(book.getStatus());
            }
        }

        if (bookReferenceList.isEmpty()) {
            System.out.println("EMPTY!!!!");
        }

    }


    @Test
    @Transactional
    public void findMultipleParameters() {

        List<BookReference> bookReferenceList =
                bookResearchManager.findBookMultiParameters("Sur", "Italie", -1, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList.size(), 1);

        List<BookReference> bookReferenceList2 =
                bookResearchManager.findBookMultiParameters("Sur", "Italie", 1, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList2.size(), 1);

        List<BookReference> bookReferenceList3 =
                bookResearchManager.findBookMultiParameters("Sur", "Italie", 2, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList3.size(), 0);

        List<BookReference> bookReferenceList4 =
                bookResearchManager.findBookMultiParameters("sur", "Italie", -1, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList4.size(), 1);

        List<BookReference> bookReferenceList5 =
                bookResearchManager.findBookMultiParameters("Sur", "Ital", -1, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList5.size(), 1);

        List<BookReference> bookReferenceList6 =
                bookResearchManager.findBookMultiParameters("Su", "Italie", -1, Arrays.asList("Sport", "Aventure", "Ecologie"));
        assertEquals(bookReferenceList6.size(), 0);

        List<BookReference> bookReferenceList7 =
                bookResearchManager.findBookMultiParameters("Sur", "Italie", -1, Arrays.asList("Sport", "Ecologie", "Ecologie"));
        assertEquals(bookReferenceList7.size(), 1);

        List<BookReference> bookReferenceList8 =
                bookResearchManager.findBookMultiParameters("", "Italie", -1, Arrays.asList());
        assertEquals(bookReferenceList8.size(), 3);

        List<BookReference> bookReferenceList9 =
                bookResearchManager.findBookMultiParameters("", "", -1, Arrays.asList("Architecture"));
        assertEquals(bookReferenceList9.size(), 2);

        List<BookReference> bookReferenceList10 =
                bookResearchManager.findBookMultiParameters("Sur", "", -1, Arrays.asList());
        assertEquals(bookReferenceList10.size(), 1);

    }

    @Test
    public void extendLoan(){
        loanManager.extendLoan(106);
    }


}
