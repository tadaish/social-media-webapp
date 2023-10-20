/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nltt.pojo.PostPhoto;
import com.nltt.pojo.Posts;
import com.nltt.repository.PhotoRepository;
import com.nltt.service.PhotoService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<PostPhoto> getPhotoByPostId(int postId) {
        return this.photoRepo.getPhotoByPostId(postId);
    }

    @Override
    public void addPhoto(Posts p, MultipartFile[] files) {
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        PostPhoto photo = new PostPhoto();
                        photo.setPostId(p);
                        Map res = this.cloudinary.uploader().upload(file.getBytes(),
                                ObjectUtils.asMap("resource_type", "auto"));
                        photo.setPhoto(res.get("secure_url").toString());
                        this.photoRepo.addPhoto(photo);
                    } catch (IOException ex) {
                        Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    @Override
    public List<PostPhoto> getPhotos() {
        return this.photoRepo.getPhotos();
    }

}
