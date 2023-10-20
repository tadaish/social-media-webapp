/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.service;

import com.nltt.pojo.Comments;
import java.util.List;

/**
 *
 * @author tadai
 */
public interface CommentService {
    List<Comments> getComments(int postId);
    Comments addComment(Comments c);
    boolean deleteComment(int commentId);
}
