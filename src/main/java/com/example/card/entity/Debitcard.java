package com.example.card.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.OneToMany;
import java.util.List;

@Document(collection = "Card")
@Data
public class Debitcard{
    @Id
    @Transient
    public static final String SEQUENCE_NAME = "card_sequence";
    private long id;
    @Indexed(unique=true)
    private String idcard;
    private String cardtype;
    private String idclient;
    private String created;
    private String clienttype;
    private String principalaccount;
    private String accounttype;

    @OneToMany
    private List<Account> account;


}
