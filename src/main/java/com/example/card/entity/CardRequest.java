package com.example.card.entity;

import lombok.Data;
@Data
public class CardRequest {

    private String idcard;
    private String cardtype;
    private double balance;
    private String idclient;
    private String clienttype;
    private String currency;

}
