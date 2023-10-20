/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.repository;

import com.nltt.pojo.Posts;
import java.util.List;

/**
 *
 * @author tadai
 */
public interface PostRepository {
    List<Posts> getPosts();
    List<Posts> getPostsByUser(int userID);
    Posts addOrEditPost(Posts p);
    boolean deletePost(int postID);
    int countPost();
 
}
