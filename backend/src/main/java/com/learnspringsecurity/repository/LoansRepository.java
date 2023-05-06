package com.learnspringsecurity.repository;

import com.learnspringsecurity.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends CrudRepository<Loans,Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(Long customerId);
}
