package com.example.card.controller;

import com.example.card.Service.SequenceGeneratorService;
import com.example.card.entity.*;
import com.example.card.repository.DebitcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Debit")
public class DebitcardController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private DebitcardRepository debitcardRepository;

    @PostMapping
    public Debitcard save(@RequestBody Debitcard debitcard) {

        Date date = new Date();
/*
        Account account = new Account();

debitcard.getAccount().stream()
        .map(d -> setAdded(date));

        .map(c -> LocalDateTime.parse(c.getCreated(), formatter).toLocalDate().getMonth());

        List<Account> accounts = new ArrayList<>();
        accounts = debitcard.getAccount();

        account.setIdaccount(accounts.getIdaccount);

        accounts.set
*/
        debitcard.setId(sequenceGeneratorService.generateSequence(Debitcard.SEQUENCE_NAME));
        debitcard.setCreated(date);


        return debitcardRepository.save(debitcard);    }

    @GetMapping
    public List<Debitcard> findall() {
        return debitcardRepository.findByCardtype("Debit");
    }

    @GetMapping("/Idclients/{idclient}")
    public Debitcard find2(@PathVariable String idclient) {
        return debitcardRepository.findByIdclient(idclient);
    }

    @GetMapping("/Idcards/{idcard}")
    public Debitcard find(@PathVariable String idcard) {
        return debitcardRepository.findByIdcard(idcard);
    }

    @PatchMapping("/{idcard}")
    public Debitcard addaccount(@PathVariable String idcard, @RequestBody Account account) {

        Date date = new Date();

        Debitcard debitcard = debitcardRepository.findByIdcard(idcard);

        account.setAdded(date);

        debitcard.getAccount().add(account);

        return debitcardRepository.save(debitcard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        debitcardRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Debitcard update(@PathVariable long id, @RequestBody Debitcard debitcard) {
        return debitcardRepository.save(debitcard);    }
}