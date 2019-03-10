package com.epam.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Users {

    private int id_users;
    @Size(min=2, max=30,message = "Имя должно быть не менее 2 символов и не больше 30")
    private String name;
    @Size(min=2, max=30,message = "Фамилия должно быть не менее 2 символов и не больше 30")
    private String last_name;
    private long number_card;
    @Size(min=5, max=10,message = "Пароль должен быть больше 5 символов и не больше 10")
    private String password;
    @Size(min=2, max=30,message = "Логин должно быть не менее 2 символов и не больше 30")
    private String login;
    private String role;
    @Email(message = "Это должен быть email")
    private String email;

    public Users(int id_users,String name, String last_name, long number_card, String password, String login, String role, String email) {
        this.id_users = id_users;
        this.name = name;
        this.last_name = last_name;
        this.number_card = number_card;
        this.password = password;
        this.login = login;
        this.role = role;
        this.email = email;
    }

    public Users(){

    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

        public long getNumber_card() {
        return number_card;
    }

    public void setNumber_card(long number_card) {
        this.number_card = number_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id_users=" + id_users +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number_card=" + number_card +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
