package com.example.card.controller;

import com.example.card.Service.SequenceGeneratorService;
import com.example.card.entity.*;
import com.example.card.repository.DebitcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
@RestController
@RequestMapping("/debit")
public class DebitcardController {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private DebitcardRepository debitcardRepository;
    @PostMapping
    public Debitcard save(@RequestBody Debitcard debitcard) {

        List<Account> accounts = debitcard.getAccount();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        Account account = accounts.get(0);
        if (account.getIdaccount() != null) {
            account.setAdded(LocalDateTime.now().format(formatter));
            accounts.set(0, account);
        }

        debitcard.setAccount(accounts);

        debitcard.setId(sequenceGeneratorService.generateSequence(Debitcard.SEQUENCE_NAME));
        debitcard.setCreated(LocalDateTime.now().format(formatter));

        return debitcardRepository.save(debitcard);    }

    @GetMapping
    public List<Debitcard> findall() {
        return debitcardRepository.findByCardtype("Debit");
    }

    @GetMapping("/idclients/{idclient}")
    public Debitcard find2(@PathVariable String idclient) {
        return debitcardRepository.findByIdclient(idclient);
    }

    @GetMapping("/idcards/{idcard}")
    public Debitcard find(@PathVariable String idcard) {
        return debitcardRepository.findByIdcard(idcard);
    }

    @PatchMapping("/{idcard}")
    public Debitcard addaccount(@PathVariable String idcard, @RequestBody Account account) {

        Debitcard debitcard = debitcardRepository.findByIdcard(idcard);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        account.setAdded(LocalDateTime.now().format(formatter));

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        if (debitcard.getAccount().get(0).getIdaccount() == null) {
            debitcard.setAccount(accounts);
        } else {
            debitcard.getAccount().add(account);        }
        return debitcardRepository.save(debitcard);    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        debitcardRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Debitcard update(@PathVariable long id, @RequestBody Debitcard debitcard) {
        return debitcardRepository.save(debitcard);
    }
}