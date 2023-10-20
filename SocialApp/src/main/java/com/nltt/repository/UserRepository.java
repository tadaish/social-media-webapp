/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.repository;

import com.nltt.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tadai
 */
public interface UserRepository {
    List<Users> getUsers(Map<String, String> params);
    Users getUserById(int userID);
    Users getUserByUsername(String username);
    boolean authUser(String username, String password);
    Users addUser(Users user);
    boolean deleteUser(int userId);
    int countUsers();
}
