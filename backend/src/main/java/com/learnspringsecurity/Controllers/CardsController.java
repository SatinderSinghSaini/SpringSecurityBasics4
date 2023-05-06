package com.learnspringsecurity.Controllers;

import com.learnspringsecurity.model.Cards;
import com.learnspringsecurity.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;
    @GetMapping(path = "cards")
    public List<Cards> getCards(@RequestParam Long id){
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if(cards != null){
            return cards;
        }else{
            return null;
        }
    }
}
