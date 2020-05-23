package com.epam.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "credit_card")
public class CreditCard {

    @Id
    private BigInteger idUsers;

    @Field("number_card")
    private int numberCard;

    private BigDecimal balance;

    private boolean block;

}

