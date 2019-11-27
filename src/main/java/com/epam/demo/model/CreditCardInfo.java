package com.epam.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInfo {

    @Getter
    @Setter
    private long id_users;
    @Getter
    @Setter
    private int number_card;
    @Getter
    @Setter
    private BigDecimal balance;
    @Getter
    @Setter
    private boolean block;





}
