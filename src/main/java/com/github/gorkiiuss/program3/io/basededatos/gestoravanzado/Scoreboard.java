package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado;

import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.impls.UserDAOMockImpl;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.impls.UserDAOMySQLImpl;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.services.ServiceUser;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo.User;

import java.time.LocalDate;
import java.util.Date;

public class Scoreboard {
    // Datos que irian en un archivo properties
    public static final String TITLE = "Scoreboard Manager - Demo";
    public static final String DB_NAME = "scoreboard";
    public final static String MY_SQL_USER = "java";
    public final static String MY_SQL_PASSWORD = "java";
    public static final String INVALID_DAO_ERROR_MSG = "The DAO is invalid";

    public static void main(String[] args) {
        // Utilizando un DAO falso
        ServiceUser mockServiceUser = new ServiceUser(new UserDAOMockImpl());
        mockServiceUser.registerUser(new User("username1", "password1", "name1", "surname1", new Date(10)));
        mockServiceUser.registerUser(User.NON_EXISTENT);
        mockServiceUser.registerUser(User.INVALID);

        for (User user : mockServiceUser.getAllUsers()) {
            System.out.println(user);
        }

        // Utilizando un DAO de MySQL
        ServiceUser mySQLServiceUser = new ServiceUser(UserDAOMySQLImpl.Builder.init().build());
        mySQLServiceUser.registerUser(new User("username1", "password1", "name1", "surname1", new Date(92384)));
        mySQLServiceUser.registerUser(new User("username2", "password2", "name2", "surname2", new Date(273459345857L)));

        for (User user : mySQLServiceUser.getAllUsers()) {
            System.out.println(user);
        }
    }
}
