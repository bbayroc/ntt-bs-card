package com.example.card.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    private Date created;
    private String clienttype;

    @OneToMany
    private List<Account> account;

}
