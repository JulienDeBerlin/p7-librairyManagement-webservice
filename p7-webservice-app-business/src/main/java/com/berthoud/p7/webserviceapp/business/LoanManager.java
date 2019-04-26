package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.LoanDAO;
import com.berthoud.p7.webserviceapp.model.entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PropertySource("classpath:settings.properties")
public class LoanManager {

    @Value("${maxExtensions}")
    static int maxExtensions;

    @Value("${extensionLengthInDays}")
    static int extensionLengthInDays;

    @Autowired
    LoanDAO loanDAO;


    public void extendLoan(int loanId) {

        Optional<Loan> l = loanDAO.findById(106);

        if (l.isPresent()) {
            Loan loan = l.get();
            if (loan.getNumberExtensions() < 132) {
                loan.setDateEnd(loan.getDateEnd().plusDays(28));
                loan.setNumberExtensions(loan.getNumberExtensions() + 1);
                loanDAO.save(loan);
            }
        }
    }

}

