package com.berthoud.p7.webserviceapp.consumer.contract;

import com.berthoud.p7.webserviceapp.model.entities.Loan;

import java.util.Optional;

public interface LoanDAO {

    Optional<Loan> findById (int loanId);

    Loan save(Loan loan);
}
