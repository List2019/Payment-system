package com.epam.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    public User(String password, String login) {
        this.password = password;
        this.login = login;
    }

    @Id
    private BigInteger idUsers;

    private String name;

    @Field("last_name")
    private String lastName;

    @Field("number_card")
    private int numberCard;

    private String password;

    private String login;

    private String role;

    private String email;


}
