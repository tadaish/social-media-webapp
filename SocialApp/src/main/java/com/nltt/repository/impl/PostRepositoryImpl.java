/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.repository.impl;

import com.nltt.pojo.Posts;
import com.nltt.repository.PostRepository;
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
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Posts> getPosts() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Posts");

        return q.getResultList();
    }

    @Override
    public List<Posts> getPostsByUser(int userID) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Posts where userID.userID=:id");
        q.setParameter("id", userID);

        return q.getResultList();
    }

    @Override
    public Posts addOrEditPost(Posts p) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {
            if (p.getPostID()== null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return p;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
      public Posts getPostsById(int postID){
         Session s = this.sessionFactory.getObject().getCurrentSession();
         return s.get(Posts.class, postID);
    }

    @Override
    public boolean deletePost(int postID) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Posts p = this.getPostsById(postID);
        
         try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int countPost() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("select count(*) from Posts");
        
        return Integer.parseInt(q.getSingleResult().toString());
    }

}
