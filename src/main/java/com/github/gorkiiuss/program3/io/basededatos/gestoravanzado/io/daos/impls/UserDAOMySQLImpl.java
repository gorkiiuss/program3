package com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.impls;

import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.Scoreboard;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.io.daos.UserDAO;
import com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.modelo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.github.gorkiiuss.program3.io.basededatos.gestoravanzado.Scoreboard.INVALID_DAO_ERROR_MSG;

public class UserDAOMySQLImpl implements UserDAO {
    public final static UserDAOMySQLImpl INVALID = new UserDAOMySQLImpl(null);
    private final static String TABLE_NAME = "users";
    private final static String CONNECTION_URL = "mysql:jdbc//localhost:3306/" + Scoreboard.DB_NAME;

    private final Connection connection;
    private final Logger logger = Logger.getLogger(UserDAOMySQLImpl.class.getName());



    private UserDAOMySQLImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addUser(User user) {
        if (this == INVALID) throw new RuntimeException(INVALID_DAO_ERROR_MSG);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_NAME +
                            " (username, password, name, surname, birthdate, register_date) VALUES (?, ?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setDate(5, new Date(user.getBirthdate().getTime()));
            preparedStatement.setDate(6, new Date(user.getRegisterDate().getTime()));
            /* The registration date gets set as a default value */

            preparedStatement.execute();
        }
        catch (SQLException e) { return false; }
        return true;
    }

    @Override
    public User[] getAllUsers() {
        if (this == INVALID) throw new RuntimeException(INVALID_DAO_ERROR_MSG);

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM " + TABLE_NAME);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("username");
                String name = resultSet.getString("username");
                String surname = resultSet.getString("username");
                Date birthdate = resultSet.getDate("birthdate");
                Date registerDate = resultSet.getDate("register_date");

                users.add(new User(username, password, name, surname, birthdate, registerDate));
            }

            return users.toArray(new User[0]);
        } catch (SQLException e) {
            return new User[0];
        }
    }

    @Override
    public User getUser(String username) {
        User user;
        if (this == INVALID) throw new RuntimeException(INVALID_DAO_ERROR_MSG);

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) user = new User(
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    new java.util.Date(resultSet.getDate("birthdate").getTime()),
                    new java.util.Date(resultSet.getDate("register_date").getTime())
            );
            else user = User.NON_EXISTENT;
        } catch (SQLException e) { user = User.INVALID; }

        return user;
    }

    public static class Builder {
        private final Logger logger = Logger.getLogger(Builder.class.getName());

        private String connectionURL = "jdbc:mysql://localhost:3306/" + Scoreboard.DB_NAME;
        private String mySQLUser = "java";
        private String mySQLPassword = "java";

        private Builder() {
            logger.info("Initializing builder with default UserDAOMySQL values: \n" + attributesToString());
        }

        public static Builder init() {
            return new Builder();
        }

        public Builder setConnectionURL(String connectionURL) {
            this.connectionURL = connectionURL;
            return this;
        }

        public Builder setMySQLUser(String mySQLUser) {
            this.mySQLUser = mySQLUser;
            return this;
        }

        public Builder setMySQLPassword(String mySQLPassword) {
            this.mySQLPassword = mySQLPassword;
            return this;
        }

        public UserDAOMySQLImpl build() {
            UserDAOMySQLImpl userDAOMySQL;
            try {
                Connection connection = DriverManager.getConnection(connectionURL, mySQLUser, mySQLPassword);
                logger.info("Created new UserDAOMySQL with values: \n" + attributesToString());
                userDAOMySQL = new UserDAOMySQLImpl(connection);
            } catch (SQLException e) {
                logger.severe("Error building UserDAOMySQL object! " + e.getMessage());
                userDAOMySQL = UserDAOMySQLImpl.INVALID;
            }

            return userDAOMySQL;
        }

        private String attributesToString() {
            return "\t- connectionURL: " + connectionURL + ",\n" +
                    "\t- mySqlUser: " + mySQLUser + ",\n" +
                    "\t- mySQLPassword: " + mySQLPassword;
        }
    }
}
