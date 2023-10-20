/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.service;

import com.nltt.pojo.Posts;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
public interface PostService {
    List<Posts> getPosts();
    List<Posts> getPostsByUser(int userID);
    Posts addOrEditPost(Posts p);
    boolean deletePost(int postID);
    int countPost();
}
