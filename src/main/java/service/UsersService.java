package service;

import dao.UsersDAO;
import entity.Users;
import util.ConnectionManager;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class UsersService implements UsersDAO {
    Connection connection = null;

    @Override
    public int addUser(Users user) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO users " +
                     "(user_name, password, admin) " +
                     "VALUES (?,?,?);";
        int testAddUser = 0;
        try {
            connection = ConnectionManager.open();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.isAdmin());
            testAddUser = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null && connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testAddUser;
    }

    @Override
    public Set<Users> getAllUsers() {
        Statement statement = null;
        Set<Users> setList = new HashSet<>();

        String sql = "SELECT DISTINCT * FROM users;";
        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                boolean admin = resultSet.getBoolean(4);
                Users users = new Users(userId, userName, password, admin);
                setList.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null && connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return setList;
    }

    public Users getUser(String name, String password) {

        Users user = new Users();
        Statement statement = null;

        String sql = "SELECT user_name, password, admin FROM  users WHERE user_name = '" + name + "' AND password = '" + password + "';";

        try {
            connection = ConnectionManager.open();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String rName = resultSet.getString(1);
                String rPassword = resultSet.getString(2);
                boolean rAdmin = resultSet.getBoolean(3);

                user.setUserName(rName);
                user.setPassword(rPassword);
                user.setAdmin(rAdmin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null && connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
