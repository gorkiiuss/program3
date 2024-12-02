package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.services;

import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.UserDAO;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo.User;

public class ServiceUser {
    private UserDAO dao;

    public ServiceUser(UserDAO dao) {
        this.dao = dao;
    }

    public boolean registerUser(User user) {
        return dao.addUser(user);
    }

    public User getUser(String username) {
        return dao.getUser(username);
    }

    public User[] getAllUsers() {
        return dao.getAllUsers();
    }
}
