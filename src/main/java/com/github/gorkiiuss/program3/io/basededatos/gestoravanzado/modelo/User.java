package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class User {
    public static final User INVALID =
            new User(null, null, null, null, null, null);
    public static final User NON_EXISTENT =
            new User(null, null, null, null, null, null);

    private final String username;
    private String password;
    private String name;
    private String surname;
    private Date birthdate;
    private Date registerDate;

    public User(String username, String password, String name, String surname, Date birthdate, Date registerDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.registerDate = registerDate;
    }

    public User(String username, String password, String name, String surname, Date birthdate) {
        this(username, password, name, surname, birthdate,
                Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean hasUsername(String username) {
        return this.username.equals(username);
    }

    @Override
    public String toString() {
        if (this == INVALID) return "Invalid user";
        if (this == NON_EXISTENT) return "Non-existent user";
        return surname + ", " + name + " (@" + username + "): " +
                "Birthdate " + birthdate + ", Register date " + registerDate;
    }
}
