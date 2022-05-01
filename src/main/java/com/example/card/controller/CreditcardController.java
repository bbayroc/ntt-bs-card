package com.example.card.controller;

import com.example.card.entity.BalanceUpdate;
import com.example.card.entity.Creditcard;
import com.example.card.entity.CardRequest;
import com.example.card.repository.CardRepository;
import com.example.card.repository.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Cards")
public class CreditcardController {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private Validator validator;
    @PostMapping
    public Creditcard save(@RequestBody CardRequest cardRequest) {
        return cardRepository.save(validator.productvalidator(cardRequest));    }
    @GetMapping
    public List<Creditcard> findall() {
        return cardRepository.findAll();
    }
    @GetMapping("/Idclients/{idclient}")
    public Creditcard find2(@PathVariable String idclient) {
        return cardRepository.findByIdclient(idclient);
    }
    @GetMapping("/Idcards/{idcard}")
    public Creditcard find(@PathVariable String idcard) {
        return cardRepository.findByIdcard(idcard);
    }
    @PatchMapping("/{idcard}")
    public Creditcard patch(@PathVariable String idcard, @RequestBody BalanceUpdate balanceUpdate) {

        Creditcard creditcard = cardRepository.findByIdcard(idcard);

        creditcard.setBalance(creditcard.getBalance() + balanceUpdate.getBalance());
        return cardRepository.save(creditcard);    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        cardRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Creditcard update(@PathVariable long id, @RequestBody Creditcard creditcard) {
        return cardRepository.save(creditcard);    }
}