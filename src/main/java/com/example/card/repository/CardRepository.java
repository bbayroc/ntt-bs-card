package com.example.card.repository;

import com.example.card.entity.Creditcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Creditcard, Long> {

    Creditcard findByIdcard(String idcard);
    List<Creditcard> findByIdclientAndCardtype(String idclient, String credit);

    List<Creditcard> findByCardtype(String cardtype);

    void deleteByIdcard(String idcard);
}
