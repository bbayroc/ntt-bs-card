package com.example.card.repository;

import com.example.card.entity.Creditcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Creditcard, Long> {

    Creditcard findByIdcard(String idcard);
    Creditcard findByIdclient(String idclient);


}
