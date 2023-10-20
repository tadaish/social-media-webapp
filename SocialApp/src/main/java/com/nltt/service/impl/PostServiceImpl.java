/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nltt.pojo.PostPhoto;
import com.nltt.pojo.Posts;
import com.nltt.pojo.Users;
import com.nltt.repository.PhotoRepository;
import com.nltt.repository.PostRepository;
import com.nltt.repository.UserRepository;
import com.nltt.service.PostService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PhotoRepository photoRepo;

    @Override
    public List<Posts> getPosts() {
        return this.postRepo.getPosts();
    }

    @Override
    public List<Posts> getPostsByUser(int userID) {
        return this.postRepo.getPostsByUser(userID);
    }

    @Override
    public Posts addOrEditPost(Posts p) {
        p.setPostDate(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users u = this.userRepo.getUserByUsername(authentication.getName());
        p.setUserID(u);
        return  this.postRepo.addOrEditPost(p);
    }

    @Override
    public boolean deletePost(int postID) {
        return this.postRepo.deletePost(postID);
    }

    @Override
    public int countPost() {
        return this.postRepo.countPost();
    }

}
