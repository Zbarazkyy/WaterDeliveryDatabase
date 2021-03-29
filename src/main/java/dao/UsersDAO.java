package dao;

import entity.Users;

import java.util.Set;


public interface UsersDAO {

    int addUser(Users user);

    Set<Users> getAllUsers();

    Users getUser(String name, String password);

}
