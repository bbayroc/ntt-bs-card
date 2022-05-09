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
@RequestMapping("/cards")
public class CreditcardController {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private Validator validator;
    @PostMapping
    public Creditcard save(@RequestBody CardRequest cardRequest) {
        cardRequest.setCardtype("Credit");
        return cardRepository.save(validator.productvalidator(cardRequest));    }
    @GetMapping("/all")
    public List<Creditcard> findall() {
        return cardRepository.findByCardtype("Credit");
    }
    @GetMapping("/idclients/{idclient}")
    public List<Creditcard> find2(@PathVariable String idclient) {
        return cardRepository.findByIdclientAndCardtype(idclient, "Credit");
    }
    @GetMapping("/idcards/{idcard}")
    public Creditcard find(@PathVariable String idcard) {
        return cardRepository.findByIdcard(idcard);
    }
    @PatchMapping("/{idcard}")
    public Creditcard patch(@PathVariable String idcard, @RequestBody BalanceUpdate balanceUpdate) {

        Creditcard creditcard = cardRepository.findByIdcard(idcard);

        creditcard.setBalance(creditcard.getBalance() + balanceUpdate.getBalance());
        return cardRepository.save(creditcard);    }

    //Borra ambos tips de tarjeta buscando por idcard
    @DeleteMapping("/{idcard}")
    public void delete(@PathVariable String idcard) {
        cardRepository.deleteByIdcard(idcard);
    }
    @PutMapping("/{id}")
    public Creditcard update(@PathVariable long id, @RequestBody Creditcard creditcard) {
        return cardRepository.save(creditcard);    }
}