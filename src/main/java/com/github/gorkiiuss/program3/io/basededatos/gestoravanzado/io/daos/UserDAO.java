package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos;

import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo.User;

public interface UserDAO {
    boolean addUser(User user);
    User getUser(String username);
    User[] getAllUsers();
}
