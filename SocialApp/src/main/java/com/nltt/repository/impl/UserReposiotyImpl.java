/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.repository.impl;

import com.nltt.pojo.Users;
import com.nltt.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tadai
 */
@Repository
@Transactional
public class UserReposiotyImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Users where username=:un");
        q.setParameter("un", username);

        return (Users) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        Users u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public Users addUser(Users user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        s.save(user);

        return user;
    }

    @Override
    public List<Users> getUsers(Map<String, String> params) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root root = q.from(Users.class);
        q.select(root);
        
         if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("username"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
         Query query = s.createQuery(q);
         
         return query.getResultList();
    }

    @Override
    public Users getUserById(int userID) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Users.class, userID);
    }

    @Override
    public boolean deleteUser(int userID) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Users u = this.getUserById(userID);

        try {
            s.delete(u);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public int countUsers() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("select count(*) from Users");

        return Integer.parseInt(q.getSingleResult().toString());
    }

}
