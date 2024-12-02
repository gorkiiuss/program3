package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.impls;

import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.UserDAO;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo.User;

import java.util.ArrayList;

public class UserDAOMockImpl implements UserDAO {
    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean addUser(User user) {
        return this.users.add(user);
    }

    @Override
    public User getUser(String username) {
        return users.stream().filter(user -> user.hasUsername(username)).findFirst().orElse(User.NON_EXISTENT);
    }

    @Override
    public User[] getAllUsers() {
        return users.toArray(new User[0]);
    }
}
