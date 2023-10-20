/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.repository.impl;

import com.nltt.pojo.Comments;
import com.nltt.repository.CommentRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tadai
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    

    @Override
    public List<Comments> getComments(int postId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Comments where postID.postID=:id");
        q.setParameter("id", postId);
        
        return q.getResultList();
    }

    @Override
    public Comments addComment(Comments c) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Comments getCommentById(int commentID){
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Comments.class, commentID);
    }

    @Override
    public boolean deleteComment(int commentId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Comments c = this.getCommentById(commentId);
        
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
