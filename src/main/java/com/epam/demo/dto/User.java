package com.epam.demo.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Getter
    @Setter
    private int idUser;
    @Size(min=2, max=30,message = "Имя должно быть не менее 2 символов и не больше 30")
    @Getter
    @Setter
    private String name;
    @Size(min=2, max=30,message = "Фамилия должно быть не менее 2 символов и не больше 30")
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private long numberCard;
    @Size(min=5, max=10,message = "Пароль должен быть больше 5 символов и не больше 10")
    @Getter
    @Setter
    private String password;
    @Size(min=2, max=30,message = "Логин должно быть не менее 2 символов и не больше 30")
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String role;
    @Email(message = "Это должен быть email")
    @Getter
    @Setter
    private String email;

}
