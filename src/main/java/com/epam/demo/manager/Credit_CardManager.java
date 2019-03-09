package com.epam.demo.manager;

import com.epam.demo.dto.Credit_Card;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class Credit_CardManager {

    private Credit_Card credit_card;

    public Credit_Card getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(Credit_Card credit_card) {
        this.credit_card = credit_card;
    }
}
