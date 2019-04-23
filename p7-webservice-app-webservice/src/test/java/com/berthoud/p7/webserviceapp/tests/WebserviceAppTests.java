//package com.berthoud.p7.webserviceapp.tests;
//
//import com.berthoud.p7.webserviceapp.business.CustomerManager;
//import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.BookRepository;
//import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.CustomerRepository;
//import com.berthoud.p7.webserviceapp.consumer.repositories.SpringDataJPA.LoanRepository;
//import com.berthoud.p7.webserviceapp.model.entities.Address;
//import com.berthoud.p7.webserviceapp.model.entities.Book;
//import com.berthoud.p7.webserviceapp.model.entities.Customer;
//import com.berthoud.p7.webserviceapp.model.entities.Loan;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WebserviceAppTests {
//
//    @Autowired
//    CustomerRepository customerRepo;
//    @Autowired
//    LoanRepository loanRepo;
//
//    @Autowired
//    BookRepository bookRepo;
//
//    @Autowired
//    CustomerManager customerManager;
//
//    @Test
//    public void contextLoads() {
//    }
//
//
//    @Test
//    public void testRead() {
//        if (customerRepo.findById(4).isPresent()) {
//            Customer customer = customerRepo.findById(4).get();
//            System.out.println(customer.getSurname());
//        }
//
//    }
//
//
//    @Test
//    public void testUpdate() {
//        Optional<Customer> customer = customerRepo.findById(2);
//        if (customer.isPresent()) {
//            Customer myCustomer = customer.get();
//            myCustomer.setSurname("Dubuc");
//            customerRepo.save(myCustomer);
//        }
//    }
//
//    @Test
//    public void testDelete() {
//        if (customerRepo.existsById(3)) {
//            customerRepo.deleteById(3);
//        }
//
//    }
//
//    @Test
//    public void testCount() {
//        System.out.println("Total records: =============" + customerRepo.count());
//
//    }
//
//    @Test
//    public void testFindBy() {
//        List<Customer> listCustomer = customerRepo.findBySurnameIgnoreCase("PierRE");
//        for (Customer c : listCustomer) {
//            System.out.println(">>>>>>>>>>>>id = " + c.getId());
//        }
//    }
//
//
//    @Test
//    public void testFindAllJPQL() {
//        customerRepo.findAllJPQL().forEach(customerEntity -> System.out.println(customerEntity.getFirstName()));
//    }
//
//    @Test
//    public void testFindAllPartialData() {
//        customerRepo.findAllPartialData().forEach(objects -> System.out.println(objects[0] + "/" + objects[1] + "/" + objects[2]));
//
//    }
//
//
//    @Test
////    @Transactional
//    public void insertUsers() {
//
//        Customer c1 = new Customer();
//        c1.setSurname("Malika");
//        c1.setFirstName("Djarir");
//        c1.setNickname("adjarir");
//        c1.setPassword("soleil");
//        c1.setSex("F");
//        c1.setPhone("0385303955");
//        c1.setEmail("aicha@yahoo.fr");
//
//        Address address = new Address();
//        address.setHouseNumber(13);
//        address.setCity("Paris");
//        address.setZipCode("75009");
//        address.setRoad("rue de Milan");
//
//        c1.setAddress(address);
//
//        customerRepo.save(c1);
//    }
//
//
//    @Test
//    public void createLoan(){
//
//        Customer c = customerRepo.findById(34).get();
//        Book b =bookRepo.findById(1).get();
//
//        Loan loan = new Loan();
//        loan.setCustomer(c);
//        loan.setBook(b);
//
//        loan.setDateBegin(LocalDate.of(2019, 04, 13));
//        loan.setDateEnd(LocalDate.of(2019, 04, 23));
//        loan.setNumberExtensions(0);
//
//        loanRepo.save(loan);
//    }
//
//
//    @Test
//    public void testCreate() {
//        Customer customer = new Customer();
//        customer.setSurname("Pierre");
//        customer.setFirstName("Dubuc");
//        customer.setNickname("Pierrot");
//        customer.setPassword("soleil");
//        customer.setSex("M");
//        customer.setPhone("0385303955");
//        customer.setEmail("pierre@yahoo.fr");
//
//        customerRepo.save(customer);
//
//    }
//
//
//    @Test
//    @Transactional
//    public void testLogin() {
//        Customer customer1 = customerManager.login("mdjarir", "soleil");
//        assertNotNull(customer1);
//
//
////        Customer customer1 = customerRepo.findById(30).get();
//
//        System.out.println(customer1.getFirstName() + " " + customer1.getSurname() + "  Id=" + customer1.getId());
//        System.out.println(customer1.getAddress().getCity());
//
//        Set<Loan> loans = customer1.getLoans();
//        loans.forEach(loan -> System.out.println("Titre= " + loan.getBook().getBookReference().getTitle()+ "Debut=" + loan.getDateBegin() + "Fin:" + loan.getDateEnd()));
//
//    }
//
//
//
//
//}
