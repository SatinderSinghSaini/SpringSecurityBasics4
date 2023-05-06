package com.learnspringsecurity.repository;

import com.learnspringsecurity.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards,Long> {
    List<Cards> findByCustomerId(Long customerId);
}
