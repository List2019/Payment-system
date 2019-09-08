package com.epam.demo.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @NotNull
    @Getter
    @Setter
    private int idUsers;
    @Setter
    @Getter
    @NotNull
    @Size(min=3, max=3,message = "Номер карты должен иметь всего 3 символа")
    private long numberCard;
    @Getter
    @Setter
    @NotNull
    @PositiveOrZero(message = "Баланс должен быть положительным или равным 0")
    private BigDecimal balance;
    @Setter
    private boolean block;

    public boolean isBlock() {
        return block;
    }

}
