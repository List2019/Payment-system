package com.epam.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class User {

    private int idUser;
    @Size(min=2, max=30,message = "Имя должно быть не менее 2 символов и не больше 30")
    private String name;
    @Size(min=2, max=30,message = "Фамилия должно быть не менее 2 символов и не больше 30")
    private String lastName;
    private long numberCard;
    @Size(min=5, max=10,message = "Пароль должен быть больше 5 символов и не больше 10")
    private String password;
    @Size(min=2, max=30,message = "Логин должно быть не менее 2 символов и не больше 30")
    private String login;
    private String role;
    @Email(message = "Это должен быть email")
    private String email;

    public User(int idUser, String name, String lastName, long numberCard, String password, String login, String role, String email) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.numberCard = numberCard;
        this.password = password;
        this.login = login;
        this.role = role;
        this.email = email;
    }

    public User(){

    }

    public int getIdUser() {
        return idUser;
    }

    public String getId_usersString(){
        return String.valueOf(idUser);
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
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
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberCard=" + numberCard +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
