package com.example.card.repository;

import com.example.card.Service.SequenceGeneratorService;
import com.example.card.entity.Creditcard;
import com.example.card.entity.CardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Validator {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    public Creditcard productvalidator(CardRequest cardRequest) {

            Creditcard creditcard = new Creditcard();
            creditcard.setId(sequenceGeneratorService.generateSequence(Creditcard.SEQUENCE_NAME));
            creditcard.setIdcard(cardRequest.getIdcard());
            creditcard.setCardtype(cardRequest.getCardtype());
            creditcard.setBalance(cardRequest.getBalance());
            creditcard.setIdclient(cardRequest.getIdclient());
            creditcard.setCurrency(cardRequest.getCurrency());
            creditcard.setClienttype(cardRequest.getClienttype());
            return creditcard;
        }
    }
