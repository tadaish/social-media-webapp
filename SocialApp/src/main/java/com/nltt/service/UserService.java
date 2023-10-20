/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.service;

import com.nltt.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
public interface UserService extends UserDetailsService{
    List<Users> getUsers(Map<String, String> params);
    Users getUserByUn(String username);
    Users getUserById(int id);
    boolean authUser(String username, String password);
    Users addUser(Map<String, String> params, MultipartFile avatar, MultipartFile coverImages);
    boolean deleteUser(int userID);
    int countUser();

}
