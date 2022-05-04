db.createCollection('Card');
db.Card.insertMany(
    [{
  "_id": 2,
  "idcard": "22222222",
  "cardtype": "Credit",
  "balance": 5000,
  "idclient": "23703254",
  "clienttype": "Personal",
  "currency": "PEN",
  "_class": "com.example.card.entity.Creditcard"
},{
  "_id": 3,
  "idcard": "66666666",
  "cardtype": "Debit",
  "idclient": "23703254",
  "created": "2022-05-02T17:28:57.1101809",
  "clienttype": "Personal",
  "principalaccount": "11111111",
  "accounttype": "VIP",
  "account": [
    {}
  ],
  "_class": "com.example.card.entity.Debitcard"
},{
  "_id": 4,
  "idcard": "77777777",
  "cardtype": "Credit",
  "balance": 10000,
  "idclient": "84662894",
  "clienttype": "Enterprise",
  "currency": "PEN",
  "_class": "com.example.card.entity.Creditcard"
}]
)
