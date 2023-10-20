/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.repository;

import com.nltt.pojo.Comments;
import java.util.List;

/**
 *
 * @author tadai
 */
public interface CommentRepository {
    List<Comments> getComments(int postId);
    Comments addComment(Comments c);
    boolean deleteComment(int commentId);
}
