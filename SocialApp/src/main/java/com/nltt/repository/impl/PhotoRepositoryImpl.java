/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.repository.impl;

import com.nltt.pojo.PostPhoto;
import com.nltt.repository.PhotoRepository;
import java.util.List;
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
public class PhotoRepositoryImpl implements PhotoRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<PostPhoto> getPhotoByPostId(int postId) {
       Session s = this.sessionFactory.getObject().getCurrentSession();
       Query q = s.createQuery("from PostPhoto where postId = :id");
       q.setParameter("id", postId);
       
       return q.getResultList();
    }

    @Override
    public PostPhoto addPhoto(PostPhoto photo) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        s.save(photo);
        return photo;
    }

    @Override
    public List<PostPhoto> getPhotos() {
       Session s = this.sessionFactory.getObject().getCurrentSession();
       Query q = s.createQuery("from PostPhoto");
       
       return q.getResultList();
    }
    
}
