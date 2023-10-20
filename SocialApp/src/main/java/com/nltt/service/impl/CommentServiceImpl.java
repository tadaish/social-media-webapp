/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.service.impl;

import com.nltt.pojo.Comments;
import com.nltt.pojo.Users;
import com.nltt.repository.CommentRepository;
import com.nltt.repository.UserRepository;
import com.nltt.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tadai
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository cmtRepo;
    
    @Autowired
    private UserRepository userRepo;
    

    @Override
    public List<Comments> getComments(int postId) {
        return this.cmtRepo.getComments(postId);
    }

    @Override
    public Comments addComment(Comments c) {
       c.setTimestamp(new Date());
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users u = this.userRepo.getUserByUsername(authentication.getName());
        c.setUserID(u);
        
        return this.cmtRepo.addComment(c);
    }

    @Override
    public boolean deleteComment(int commentId) {
        return this.cmtRepo.deleteComment(commentId);
    }
    
}
