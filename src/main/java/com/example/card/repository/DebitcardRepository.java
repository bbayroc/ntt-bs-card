package com.example.card.repository;

import com.example.card.entity.Creditcard;
import com.example.card.entity.Debitcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitcardRepository extends MongoRepository<Debitcard, Long> {

    List<Debitcard> findByCardtype(String cardtype);

    Debitcard findByIdcard(String idcard);
    Debitcard findByIdclient(String idclient);

}
